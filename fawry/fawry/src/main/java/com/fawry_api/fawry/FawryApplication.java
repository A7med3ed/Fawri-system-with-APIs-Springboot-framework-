package com.fawry_api.fawry;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Slf4j
public class FawryApplication {
//	private static Logger LOG = LoggerFactory
//			.getLogger(FawryApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(FawryApplication.class, args);
	}


}
