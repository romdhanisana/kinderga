package tn.esprit.esponline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import tn.esprit.esponline.config.SwaggerConfiguration;



@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
public class KindergaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KindergaApplication.class, args);
	}

}
