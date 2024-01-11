package pe.intercorp.apimerkao;

import java.text.SimpleDateFormat;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pe.intercorp.apimerkao.entity.EntityMerkao;
import pe.intercorp.apimerkao.repository.RepoApi;
import pe.intercorp.apimerkao.repository.RepoApiLogin;
import pe.intercorp.apimerkao.repository.RepoData;

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

	@Autowired
	RepoData repoData;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		log.info(" log ini :{}", formatter.format(date));

		repoApiLogin.api_autorization = repoApiLogin.login();

		var getSaleNote = repoData.getSaleNote();
		log.info(" log getSaleNote :{}", getSaleNote.get(0).salenote.toString());

		EntityMerkao result = repoApi.getApiDAD(getSaleNote.get(0).salenote.toString(), repoApiLogin.api_autorization);

		if (result.equals("0")) {
			log.info(" log Not data found : {}",
					getSaleNote.get(0).salenote.toString());
		} else {
			int i = repoData.updateSaleNote(result);

			if (i == 1) {
				log.info(" log insert stage IFH_STG_MERKAO_GET_API_DAD OK : {}",
						getSaleNote.get(0).salenote.toString());
			}
		}

		formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date = new Date(System.currentTimeMillis());
		log.info(" log fin :{}", formatter.format(date));
	}
}
