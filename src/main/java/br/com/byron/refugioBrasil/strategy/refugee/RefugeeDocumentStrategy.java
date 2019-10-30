package br.com.byron.refugioBrasil.strategy.refugee;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.byron.refugioBrasil.domain.Document;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.ILocalStrategy;
import br.com.byron.refugioBrasil.strategy.refugee.Document.CpfValidator;
import br.com.byron.refugioBrasil.strategy.refugee.Document.IDocumentValidator;
import br.com.byron.refugioBrasil.strategy.refugee.Document.RgValidator;

@Service
public class RefugeeDocumentStrategy implements ILocalStrategy<Refugee> {

	Map<String, IDocumentValidator> validator;

	RefugeeDocumentStrategy() {

		validator = new HashMap<String, IDocumentValidator>();
		validator.put("cpfValidator", new CpfValidator());
		validator.put("rgValidator", new RgValidator());

	}

	@Override
	public String execute(Refugee refugee) {
		StringBuilder sb = new StringBuilder();
		for (Document document : refugee.getDocuments()) {
			String name = document.getClass().getSimpleName().toLowerCase() + "Validator";
			sb.append(validator.get(name).validate(document.getNumber()));
		}
		return sb.toString();
	}

}
