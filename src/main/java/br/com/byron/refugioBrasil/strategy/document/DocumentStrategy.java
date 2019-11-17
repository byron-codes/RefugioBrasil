package br.com.byron.refugioBrasil.strategy.document;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Document;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

@Component
public class DocumentStrategy implements IRefugeeStrategy {

	Map<String, IDocumentStrategy> validators;

	@Autowired
	public DocumentStrategy(Map<String, IDocumentStrategy> validators) {
		this.validators =  validators;
	}

	@Override
	public String execute(Refugee entity) {
		StringBuilder sb = new StringBuilder();
		for (Document document : entity.getDocuments()) {
			String name = document.getType().toString().toLowerCase() + "Strategy";
			sb.append(validators.get(name).execute(document));
		}
		return sb.toString();
	}

}
