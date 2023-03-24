package com.proiectps.masina;

import com.proiectps.masina.model.Caroserie;
import com.proiectps.masina.model.Masina;
import com.proiectps.masina.model.User;
import com.proiectps.masina.repository.CaroserieRepository;
import com.proiectps.masina.repository.ComponentaRepository;
import com.proiectps.masina.repository.MasinaRepository;
import com.proiectps.masina.repository.UserRepository;
import com.proiectps.masina.service.MasinaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@EntityScan
@EnableJpaRepositories
@SpringBootApplication
public class MasinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasinaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(MasinaRepository masinaRepository, UserRepository userRepository, ComponentaRepository componentaRepository, CaroserieRepository caroserieRepository,
						   MasinaService masinaService) {
		return args -> {

			Masina masina = new Masina();
			masina.setMarca("Logan");

			masinaRepository.save(masina);

			System.out.println(masinaService.findByMarca("Logan").getMarca());

			Caroserie caroserie = new Caroserie();
			caroserie.setCuloare("ROSU");

			caroserieRepository.save(caroserie);


			componentaRepository.findAll().forEach(
					componenta -> {

						System.out.println("Id: " + componenta.getId() + " Culoarea: " + ((Caroserie) componenta).getCuloare());

					}
			);
			Masina masina1 = new Masina();
			masina1.setMarca("Audi");
			masina1.setPret(400);


			List<Masina> masinaList = new ArrayList<>();
			masinaList.add(masina1);

			User user = new User();
			user.setName("User1");
			user.setId(1L);

			user.setMasinaList(masinaList);
			userRepository.save(user);

			masina.setUser(user);
			masinaRepository.save(masina);


			System.out.println(masinaService.findAllByMarca("Logan").getMarca());

		};
		}

}
