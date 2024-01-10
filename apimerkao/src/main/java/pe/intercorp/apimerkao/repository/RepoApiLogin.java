package pe.intercorp.apimerkao.repository;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import pe.intercorp.apimerkao.entity.Login;
import pe.intercorp.apimerkao.entity.User;

@Repository

public class RepoApiLogin {
    @Value("${api.url}")
    public String api_url;

    @Value("${api.username}")
    public String api_username;

    @Value("${api.password}")
    public String api_password;

    public String api_autorization;

    public String login() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        // RequestBody body = RequestBody.create(mediaType, "{\r\n \"username\" :
        // \"SPSAPMMSTOCK\",\r\n \"password\" : \"SpsaSTOCK23!\"\r\n}");

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        User user = new User();

        user.setUsername(api_username);
        user.setPassword(api_password);

        String string_body = objectMapper.writeValueAsString(user);

        RequestBody body = RequestBody.create(string_body, mediaType);

        Request request = new Request.Builder()
                .url(api_url)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();

        if (response.code() != 200) {
            return "";// "Error:"+Integer.toString(response.code());

        }

        Login login = objectMapper.readValue(response.body().byteStream(), Login.class);

        api_autorization = login.getAccess_token();

        return login.getAccess_token();

    }
}
