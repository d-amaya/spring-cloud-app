package com.springboot.microservices.controller;

import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.microservices.entity.Team;
import com.springboot.microservices.repository.TeamRepository;

//@RestController
public class TeamController {
	
	//@Autowired
	private TeamRepository teamRepository;

	//@RequestMapping(path = "/teams")
	public Iterable<Team> getTeams() {
		return teamRepository.findAll();
	}
	
	//@RequestMapping(path = "/teams/{id}")
	public Team getTeam(@PathVariable Long id) {
		return teamRepository.findOne(id);
	}
}
