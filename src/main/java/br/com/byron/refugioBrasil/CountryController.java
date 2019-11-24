package br.com.byron.refugioBrasil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.byron.refugioBrasil.domain.Country;
import br.com.byron.refugioBrasil.facade.Facade;

@Controller
@RequestMapping("/country")
public class CountryController {
	
	private final Facade<Country> facade;

	@Autowired
	public CountryController(Facade<Country> facade) {
		this.facade = facade;
	}
	
	@GetMapping()
	public @ResponseBody List<Country> listRefugiado() {
		return facade.find(new Country());
	}

}
