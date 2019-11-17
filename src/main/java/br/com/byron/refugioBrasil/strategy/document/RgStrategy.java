package br.com.byron.refugioBrasil.strategy.document;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Document;

@Component
public class RgStrategy implements IDocumentStrategy {

	@Override
	public String execute(Document rg) {
		return null;
	}

}
