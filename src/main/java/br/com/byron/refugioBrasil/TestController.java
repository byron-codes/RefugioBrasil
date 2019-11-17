package br.com.byron.refugioBrasil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.facade.Facade;

@Controller
@RequestMapping("/refugee")
public class TestController {

	private final Facade<Refugee> facade;

	@Autowired
	public TestController(Facade<Refugee> facade) {
		this.facade = facade;
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
