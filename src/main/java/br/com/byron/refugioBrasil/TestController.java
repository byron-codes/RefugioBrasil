package br.com.byron.refugioBrasil;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.byron.refugioBrasil.domain.Address;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.enums.Gender;
import br.com.byron.refugioBrasil.enums.HomeType;
import br.com.byron.refugioBrasil.facade.Facade;
import br.com.byron.refugioBrasil.strategy.document.CpfValidator;

@Controller
@RequestMapping("/teste")
public class TestController {

	private final Facade<Refugee> facade;

	@Autowired
	public TestController(Facade<Refugee> facade) {
		this.facade = facade;
	}

	@RequestMapping("/temp")
	public void teste() {
		System.err.println(new CpfValidator().execute("48964432843"));
		System.err.println(new CpfValidator().execute("489.644.328-43"));
	}

	@RequestMapping("/refugee")
	public ModelAndView testRefugee() {

		Refugee refugee = new Refugee();
		Address a = new Address();
		a.setCep("000000");
		a.setCity("AA");
		a.setHomeType(HomeType.PROPRIA);
		a.setState("SP");
		a.setCep("00000-000");
		a.setCity("Poá");
		a.setStreet("Stª Cruz");
		refugee.setStatus(true);
		refugee.setEmail("TESTE");
		refugee.setGender(Gender.NAOBINARIO);
		refugee.setCreationDate(LocalDateTime.now());
		refugee.setLastUpdate(LocalDateTime.now());
		refugee.setHash(UUID.randomUUID());
		refugee.setAddress(a);
		return null;
	}

	@RequestMapping("/novo")
	public ModelAndView novoRefugiado() {
		ModelAndView mv = new ModelAndView("/refugee/refugee");
		return mv;
	}
	
	@PostMapping("/salvar")
	public @ResponseBody void salvar(Refugee refugee) {
		facade.save(refugee);
	}

}
