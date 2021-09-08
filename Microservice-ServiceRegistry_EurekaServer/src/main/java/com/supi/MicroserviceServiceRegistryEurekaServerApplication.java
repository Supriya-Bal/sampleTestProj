package com.supi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceServiceRegistryEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceServiceRegistryEurekaServerApplication.class, args);
	}

}
