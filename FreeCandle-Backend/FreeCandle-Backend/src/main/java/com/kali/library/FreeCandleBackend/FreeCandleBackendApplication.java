package com.kali.library.FreeCandleBackend;

import com.kali.library.FreeCandleBackend.dao.AdminRepository;
import com.kali.library.FreeCandleBackend.model.Admin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class FreeCandleBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreeCandleBackendApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(AdminRepository adminRepository) {
		return args -> {
			adminRepository.save(new Admin("kali", "kaliroot", "kawtar", "itoujane", "kawtaritoujane@gmail.com", "+212642920790"));


		};
	}

}
