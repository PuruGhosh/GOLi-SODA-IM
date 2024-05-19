package com.Golisoda.storageService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.Golisoda.storageService.Repository")
//@EntityScan(basePackages = "com.Golisoda.storageService.Entity")
//@EnableAutoConfiguration
public class StorageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageServiceApplication.class, args);
	}

}
