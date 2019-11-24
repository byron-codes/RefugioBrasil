package br.com.byron.refugioBrasil.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Country;

@Component
public class CountryDao implements IDao<Country> {

	@Autowired
	ICountryDao dao;
	
	@Override
	public Country save(Country entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country update(Country entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country find(Country entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Country> findAll(Country entity) {
		List<Country> entities = new ArrayList<Country>();
		for (Country entityA : dao.findAll()) {
			if (entityA.getStatus()) {
				entities.add(entityA);
			}
		}
		return entities;
	}

	@Override
	public Country delete(Country entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
