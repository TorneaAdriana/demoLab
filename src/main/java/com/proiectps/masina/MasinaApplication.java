package com.proiectps.masina;

import com.proiectps.masina.model.Masina;
import com.proiectps.masina.model.User;
import com.proiectps.masina.repository.MasinaRepository;
import com.proiectps.masina.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MasinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasinaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(MasinaRepository masinaRepository, UserRepository userRepository) {
		return args -> {

			User user=new User();
			user.setName("User1");

			userRepository.save(user);

			Masina masina=new Masina();
			masina.setMarca("Marca1");

			masinaRepository.save(masina);



			List<Masina> masini = new ArrayList<>();
			masini.add(masina);


			masinaRepository.saveAll(masini);
			user.setMasinaList(masini);
			userRepository.save(user);

		};
		}

}
