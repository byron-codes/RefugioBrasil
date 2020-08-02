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
	public RefugeeStrategy(Map<String, IRefugeeStrategy> validators,
			Map<String, IGenericStrategy<DomainEntity>> generics) {
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
			if (e.getId() == null)
				generics.get("createStrategy").execute(e);
			else
				generics.get("updateStrategy").execute(e);
		}

		if (refugee.getNecessity().getId() == null)
			generics.get("createStrategy").execute(refugee.getNecessity());
		else
			generics.get("updateStrategy").execute(refugee.getNecessity());
		
		if (refugee.getAddress().getId() == null)
			generics.get("createStrategy").execute(refugee.getAddress());
		else
			generics.get("updateStrategy").execute(refugee.getAddress());

		if(refugee.getImage()!= null) {
			if (refugee.getImage().getId() == null)
				generics.get("createStrategy").execute(refugee.getImage());
			else
				generics.get("updateStrategy").execute(refugee.getImage());
		}
		
		for (Profession e : refugee.getProfessions()) {
			if (e.getId() == null)
				generics.get("createStrategy").execute(e);
			else
				generics.get("updateStrategy").execute(e);
		}

		for (Language e : refugee.getLanguages()) {
			if (e.getId() == null)
				generics.get("createStrategy").execute(e);
			else
				generics.get("updateStrategy").execute(e);
		}

		for (Academic e : refugee.getAcademics()) {
			if (e.getId() == null)
				generics.get("createStrategy").execute(e);
			else
				generics.get("updateStrategy").execute(e);
		}

		for (Phone e : refugee.getPhones()) {
			if (e.getId() == null)
				generics.get("createStrategy").execute(e);
			else
				generics.get("updateStrategy").execute(e);
		}

		for (Dependent e : refugee.getDependents()) {
			if (e.getId() == null)
				generics.get("createStrategy").execute(e);
			else
				generics.get("updateStrategy").execute(e);
		}

		if (refugee.getId() == null)
			generics.get("createStrategy").execute(refugee);
		else
			generics.get("updateStrategy").execute(refugee);
		
		return errors.toString();
	}

}
