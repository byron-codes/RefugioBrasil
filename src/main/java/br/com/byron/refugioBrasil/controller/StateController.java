package br.com.byron.refugioBrasil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.byron.refugioBrasil.domain.State;
import br.com.byron.refugioBrasil.facade.Facade;

@RestController
@RequestMapping("/state")
public class StateController {
	
	@Autowired
	Facade<State> facade;

	@GetMapping()
	public List<State> getAll(){
		return facade.find(new State());
	}
	
}
