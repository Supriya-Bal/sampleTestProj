package com.supi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceServiceRegistryEurekaServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceServiceRegistryEurekaServer1Application.class, args);
	}

}
