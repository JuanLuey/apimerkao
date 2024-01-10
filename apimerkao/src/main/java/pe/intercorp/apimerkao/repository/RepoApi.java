package pe.intercorp.apimerkao.repository;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        private final Logger logger = LoggerFactory.getLogger(RepoApi.class);

        public int getApiDAD(String shipment_nbr, String accesstoken) throws IOException {

                OkHttpClient client = new OkHttpClient().newBuilder()
                                .build();

                ObjectMapper objectMapper = new ObjectMapper();

                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                Request request = new Request.Builder()
                                .url(api_url2
                                                + "/" + shipment_nbr)
                                .method("GET", null)
                                .addHeader("Authorization", "Bearer " + accesstoken)
                                .build();

                Response response = client.newCall(request).execute();

                String response_body = response.body().string();

                int responseApiDAD = response.code();

                logger.info(" Response Api DAD :  {}", responseApiDAD);

                if (responseApiDAD == 200) {

                        EntityMerkao entityMerkao = objectMapper.readValue(response_body, EntityMerkao.class);

                        logger.info(" response OK :  {}", responseApiDAD);
                        return 0;

                } else if (responseApiDAD == 404) {
                        logger.info(" No data found header :  {}", responseApiDAD);
                        return 1;
                } else {
                        logger.info(" other error response:  {}", responseApiDAD);
                        return 1;
                }

        }

}
