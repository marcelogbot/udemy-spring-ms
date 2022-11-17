package com.cursoudemy.hroauth;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Logger;
import java.util.Base64;
import java.util.logging.Level;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class HrOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrOauthApplication.class, args);

		try {
			SecureRandom secureRandom = new SecureRandom();
			byte[] codeVerifierB = new byte[32];
			secureRandom.nextBytes(codeVerifierB);
			String codeVerifier = Base64.getUrlEncoder().withoutPadding().encodeToString(codeVerifierB);

			byte[] bytes =  codeVerifier.getBytes("US-ASCII");
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(bytes, 0, bytes.length);
			byte[] digest = messageDigest.digest();
			String codeChallenge = Base64.getUrlEncoder().withoutPadding().encodeToString(digest);

			System.out.println("Code verifier: "+codeVerifier);
			System.out.println("Code challenge: "+codeChallenge);

		} catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
			Logger.getLogger(HrOauthApplication.class.getName()).log(Level.SEVERE, null, ex);

		}
	}


}
