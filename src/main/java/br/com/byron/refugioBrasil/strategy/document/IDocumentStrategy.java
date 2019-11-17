package br.com.byron.refugioBrasil.strategy.document;

import br.com.byron.refugioBrasil.domain.Document;

public interface IDocumentStrategy {
	public String execute(Document entity);
}
