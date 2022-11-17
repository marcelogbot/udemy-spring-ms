package com.cursoudemy.hruser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrUserApplication implements CommandLineRunner {

	// @Autowired
    // private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// System.out.println("BRCYPT: "+ passwordEncoder.encode("87654321"));
		// System.out.println("BRCYPT: "+ passwordEncoder.encode("12345678"));
	}

}
