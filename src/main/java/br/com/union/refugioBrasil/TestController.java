package br.com.union.refugioBrasil;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.union.refugioBrasil.command.ICommand;
import br.com.union.refugioBrasil.domain.Address;
import br.com.union.refugioBrasil.domain.Refugee;
import br.com.union.refugioBrasil.enums.Gender;
import br.com.union.refugioBrasil.enums.HomeType;

@Controller
@RequestMapping("/teste")
public class TestController {

	Map<String, ICommand<Refugee>> commands;
	
	@Autowired
	public TestController(Map<String, ICommand<Refugee>> commands) {
		this.commands = commands; 
	}

	@RequestMapping("/refugee")
	public void testRefugee() {
		
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
		commands.get("saveCommand").execute(refugee);
		
	}

}
