package br.com.byron.refugioBrasil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.facade.Facade;

@Controller
@RequestMapping("/refugee")
public class RefugeeController {

	private final Facade<Refugee> facade;

	@Autowired
	public RefugeeController(Facade<Refugee> facade) {
		this.facade = facade;
	}

	@GetMapping()
	public ModelAndView listRefugiado() {
		ModelAndView mv = new ModelAndView("/refugee/list");
		return mv;
	}

	@GetMapping("/new")
	public ModelAndView novoRefugiado() {
		ModelAndView mv = new ModelAndView("/refugee/refugee");
		mv.addObject("refugee", new Refugee());
		return mv;
	}

	@GetMapping("/{id}")
	public ModelAndView editRefugiado(@PathVariable("id") String id) {
		try {
			Refugee refugee = new Refugee();
			refugee.setId(Long.parseLong(id));
			refugee = facade.find(refugee).get(0);
			ModelAndView mv = new ModelAndView("/refugee/refugee");
			mv.addObject("refugee", refugee);
			return mv;
		} catch (Exception e) {
			return new ModelAndView("redirect:/404");
		}
	}

	@PostMapping("/salvar")
	public ModelAndView salvar(Refugee refugee) {
		try {
			facade.save(refugee);
			return new ModelAndView("redirect:/refugee?status=sucesso");
		} catch (Exception e) {
			return new ModelAndView("redirect:/refugee?status=erro");
		}
	}

	@GetMapping("/table")
	public @ResponseBody List<Refugee> tabelaRefugiado() {
		return facade.find(new Refugee());
	}

	@PostMapping("/delete")
	public ModelAndView delete(@RequestParam("id") Long id) {
		try {
			Refugee refugee = new Refugee();
			refugee.setId(id);
			facade.delete(refugee);
			return new ModelAndView("redirect:/refugee?status=excluido");
		} catch (Exception e) {
			return new ModelAndView("redirect:/refugee?status=erro");
		}
	}

}
