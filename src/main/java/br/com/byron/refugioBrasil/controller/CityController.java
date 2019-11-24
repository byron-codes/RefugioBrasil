package br.com.byron.refugioBrasil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.byron.refugioBrasil.domain.City;
import br.com.byron.refugioBrasil.domain.State;
import br.com.byron.refugioBrasil.facade.Facade;

@RestController
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	Facade<City> facade;

	@GetMapping("/{state}")
	public List<City> getAll(@PathVariable("state") Long stateId){
		City city = new City();
		State state = new State();
		state.setId(stateId);
		city.setState(state);
		return facade.find(city);
	}

}
