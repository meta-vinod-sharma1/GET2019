package com.metacube.EADSession12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
@EnableJpaRepositories ("com.metacube.EADSession12.repository")
public class EadSession12Application {

	public static void main(String[] args) {
		SpringApplication.run(EadSession12Application.class, args);
	}

}
