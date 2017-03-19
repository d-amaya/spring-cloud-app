package com.springboot.microservices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.microservices.entity.Player;
import com.springboot.microservices.entity.Team;
import com.springboot.microservices.repository.TeamRepository;

@SpringBootApplication
public class LearningBootApplication {

	@Autowired
	private TeamRepository teamRepository;

	public static void main(String[] args) {
		SpringApplication.run(LearningBootApplication.class, args);
	}

	@PostConstruct
	public void init() {
		List<Team> list = new ArrayList<>();

		Set<Player> players = new HashSet<>();
		players.add(new Player("Big Easy", "Showman"));
		players.add(new Player("Buckets", "Guard"));
		players.add(new Player("Dizzy", "Guard"));

		list.add(new Team("Harlem", "Globetrotters", players));
		list.add(new Team("Washington", "Generals", null));

		teamRepository.save(list);
	}
}
