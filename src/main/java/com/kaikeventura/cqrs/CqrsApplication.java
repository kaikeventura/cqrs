package com.kaikeventura.cqrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class CqrsApplication {

	public final static String MODEL_PACKAGE = "com.kaikeventura.cqrs.product.adapters.outbound.persistence.entity";

	public final static Properties JPA_PROPERTIES = new Properties() {{
		put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
	}};

	public static void main(String[] args) {
		SpringApplication.run(CqrsApplication.class, args);
	}

}
