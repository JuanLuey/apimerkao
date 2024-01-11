package pe.intercorp.apimerkao.repository;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pe.intercorp.apimerkao.entity.EntityMerkao;

@Repository
public class RepoApi {

        @Value("${api.url2}")
        public String api_url2;

        @Value("${api.password}")
        public String api_password;

        @Autowired
        RepoData repoData;

        private final Logger logger = LoggerFactory.getLogger(RepoApi.class);

        public EntityMerkao getApiDAD(String salesNote, String accesstoken) throws IOException {

                EntityMerkao entityMerkao = null;

                OkHttpClient client = new OkHttpClient().newBuilder()
                                .build();

                ObjectMapper objectMapper = new ObjectMapper();

                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                Request request = new Request.Builder()
                                .url(api_url2
                                                + "/" + salesNote)
                                .method("GET", null)
                                .addHeader("Authorization", "Bearer " + accesstoken)
                                .build();

                Response response = client.newCall(request).execute();

                String response_body = response.body().string();

                int responseApiDAD = response.code();

                logger.info(" Response Api DAD :  {}", responseApiDAD);

                if (responseApiDAD == 200) {
                        entityMerkao = objectMapper.readValue(response_body, EntityMerkao.class);
                        logger.info(" insert stage IFH_STG_MERKAO_GET_API_DAD response : {}", responseApiDAD);
                        repoData.insertSaleNote(entityMerkao);
                } else if (responseApiDAD == 404) {
                        logger.info(" No data found response :  {}", responseApiDAD);
                        repoData.insertErrorSaleNote(salesNote, responseApiDAD);
                } else {
                        logger.info(" other error response:  {}", responseApiDAD);
                        repoData.insertErrorSaleNote(salesNote, responseApiDAD);
                }

                return entityMerkao;

        }

}
