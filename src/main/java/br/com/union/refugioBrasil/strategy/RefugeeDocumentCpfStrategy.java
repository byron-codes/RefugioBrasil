package br.com.union.refugioBrasil.strategy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.union.refugioBrasil.domain.Document;
import br.com.union.refugioBrasil.domain.Refugee;

@Service
public class RefugeeDocumentCpfStrategy implements IStrategy<Refugee>{

	Map<String, IDocumentValidator> validator;
	
	RefugeeDocumentCpfStrategy(){
		
		validator = new HashMap<String, IDocumentValidator>();
		validator.put("cpfValidator", new CpfValidator());
		validator.put("rgValidator", new RgValidator());
		
	}
	
	@Override
	public String execute(Refugee refugee) {
		StringBuilder sb = new StringBuilder();
		for(Document document: refugee.getDocuments()) {
			String name = document.getClass().getSimpleName().toLowerCase() + "Validator";
			sb.append(validator.get(name).validate(document.getNumber()));
		}
		return sb.toString();
	}

}
