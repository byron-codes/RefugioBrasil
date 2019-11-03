package br.com.byron.refugioBrasil.strategy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.byron.refugioBrasil.domain.Document;
import br.com.byron.refugioBrasil.domain.DomainEntity;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.document.CpfValidator;
import br.com.byron.refugioBrasil.strategy.document.IDocumentStrategy;
import br.com.byron.refugioBrasil.strategy.document.RgValidator;

@Service
public class RefugeeDocumentStrategy<Entity extends DomainEntity> implements IStrategy<Entity> {

	Map<String, IDocumentStrategy> validator;

	public RefugeeDocumentStrategy() {
		validator = new HashMap<String, IDocumentStrategy>();
		validator.put(CpfValidator.class.getSimpleName(), new CpfValidator());
		validator.put(RgValidator.class.getSimpleName(), new RgValidator());
	}

	@Override
	public String execute(Entity entity) {
		StringBuilder sb = new StringBuilder();
		Refugee refugee = (Refugee) entity;
		for (Document document : refugee.getDocuments()) {
			String name = document.getClass().getSimpleName().toLowerCase() + "Validator";
			sb.append(validator.get(name).execute(document.getNumber()));
		}
		return sb.toString();
	}

}
