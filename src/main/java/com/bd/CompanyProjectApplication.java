package com.bd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.bd.file.config.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(FileStorageProperties.class)
public class CompanyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyProjectApplication.class, args);
	}

}
