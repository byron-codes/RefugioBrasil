package br.com.byron.refugioBrasil.dao;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Refugee;

@Component
public class RefugeeDao extends GenericDao<Refugee> implements IGenericDao<Refugee> {

	@Override
	public Refugee save(Refugee entity) {
		return super.save(entity);
	}

}
