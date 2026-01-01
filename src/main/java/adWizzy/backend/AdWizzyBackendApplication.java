package adWizzy.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class AdWizzyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdWizzyBackendApplication.class, args);
	}

}
