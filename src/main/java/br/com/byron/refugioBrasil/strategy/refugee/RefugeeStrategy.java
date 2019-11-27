package br.com.byron.refugioBrasil.strategy.refugee;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Academic;
import br.com.byron.refugioBrasil.domain.Dependent;
import br.com.byron.refugioBrasil.domain.Document;
import br.com.byron.refugioBrasil.domain.DomainEntity;
import br.com.byron.refugioBrasil.domain.IDomain;
import br.com.byron.refugioBrasil.domain.Language;
import br.com.byron.refugioBrasil.domain.Phone;
import br.com.byron.refugioBrasil.domain.Profession;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.IGenericStrategy;
import br.com.byron.refugioBrasil.strategy.IStrategy;

@Component
public class RefugeeStrategy implements IStrategy {

	private final Map<String, IRefugeeStrategy> validators;
	private final Map<String, IGenericStrategy<DomainEntity>> generics;

	@Autowired
	public RefugeeStrategy(Map<String, IRefugeeStrategy> validators, Map<String, IGenericStrategy<DomainEntity>> generics) {
		this.validators = validators;
		this.generics = generics;
	}

	@Override
	public String execute(IDomain entity) {
		
		StringBuilder errors = new StringBuilder();
		Refugee refugee = (Refugee) entity;
		
		for (IRefugeeStrategy strategy : validators.values())
			errors.append(strategy.execute(refugee));

		for (Document e : refugee.getDocuments()) {
			generics.get("createStrategy").execute(e);
		}
		
		generics.get("createStrategy").execute(refugee.getNecessity());
		generics.get("createStrategy").execute(refugee.getBirthCountry());
		generics.get("createStrategy").execute(refugee.getAddress());
//		generics.get("createStrategy").execute(refugee.getImage());
		
		for (Profession e : refugee.getProfessions()) {
			generics.get("createStrategy").execute(e);
		}
		
		for (Language e : refugee.getLanguages()) {
			generics.get("createStrategy").execute(e);
		}
		
		for (Academic e : refugee.getAcademics()) {
			generics.get("createStrategy").execute(e);
		}
		
		for (Phone e : refugee.getPhones()) {
			generics.get("createStrategy").execute(e);
		}
		
		for (Dependent e : refugee.getDependents()) {
			generics.get("createStrategy").execute(e);
		}
		
		generics.get("createStrategy").execute(refugee);

		return errors.toString();
	}

}
