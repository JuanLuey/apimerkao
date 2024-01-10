package pe.intercorp.apimerkao;

import java.text.SimpleDateFormat;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;

import pe.intercorp.apimerkao.repository.RepoApi;
import pe.intercorp.apimerkao.repository.RepoApiLogin;

@SpringBootApplication

public class ApiDADMerkaoApplication implements CommandLineRunner {
	private final Logger log = LoggerFactory.getLogger(ApiDADMerkaoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ApiDADMerkaoApplication.class, args);
	}

	@Autowired
    RepoApiLogin repoApiLogin;

	@Autowired
	RepoApi repoApi;

	@Override
	public void run(String... args) throws Exception {
      
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
		log.info(" log ini :{}", formatter.format(date));
	
		//log.info("inicia process..."{}, formatter.format(date));

		repoApiLogin.api_autorization = repoApiLogin.login();

		int result = repoApi.getApiDAD("2400015754772", repoApiLogin.api_autorization);

        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = new Date(System.currentTimeMillis());
		log.info(" log fin :{}", formatter.format(date));
	}
}
