package br.com.byron.refugioBrasil.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.byron.refugioBrasil.domain.Document;
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
		ModelAndView mv = new ModelAndView("refugee/list");
		return mv;
	}

	@GetMapping("/new")
	public ModelAndView novoRefugiado(Refugee refugee) {
		ModelAndView mv = new ModelAndView("refugee/refugee");
		mv.addObject("refugee", refugee);
		return mv;
	}

	@GetMapping("/{id}")
	public ModelAndView editRefugiado(@PathVariable("id") String id) {
		try {
			Refugee refugee = new Refugee();
			refugee.setId(Long.parseLong(id));
			refugee = facade.find(refugee).get(0);
			ModelAndView mv = new ModelAndView("refugee/refugee");
			mv.addObject("refugee", refugee);
			return mv;
		} catch (Exception e) {
			return new ModelAndView("redirect:/404");
		}
	}

	@GetMapping("/unique/{documento}")
	public @ResponseBody Refugee getUnicoRefugiado(@PathVariable("documento") String documento) {
		
		if(documento == null || documento == "" || documento == "null") {
			return null;
		}
		
		try {
			Refugee refugee = new Refugee();
			refugee.setId(0L);
			Document doc = new Document();
			doc.setNumber(documento);
			refugee.getDocuments().add(doc);
			refugee = facade.find(refugee).get(0);
			return refugee;
		} catch (Exception e) {
			return null;
		}
		
	}

	@PostMapping("/save")
	public ModelAndView salvar(Refugee refugee) {
		List<Refugee> refugeeSaved = facade.save(refugee);
		if (refugeeSaved != null)
			return new ModelAndView("redirect:/refugee?status=sucesso");
		else
			return novoRefugiado(refugee);
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
	
	@GetMapping("{id}/image")
	public ResponseEntity<byte[]> getImage(@PathVariable("id") String IdS) {
		try {
			Long id = Long.parseLong(IdS);
			Refugee refugee = new Refugee();
			refugee.setId(id);
			refugee = facade.find(refugee).get(0);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());
			headers.setContentType(MediaType.parseMediaType(refugee.getImage().getType()));
			headers.setContentLength(refugee.getImage().getSize());
			Path path = Paths.get(refugee.getImage().getPath());
			ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(Files.readAllBytes(path), headers,
					HttpStatus.OK);
			return responseEntity;
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}

}
