package br.com.byron.refugioBrasil.strategy.document.validators;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Document;
import br.com.byron.refugioBrasil.strategy.document.IDocumentStrategy;

@Component
public class RgStrategy implements IDocumentStrategy {

	@Override
	public String execute(Document rg) {
		return "";
	}

}
