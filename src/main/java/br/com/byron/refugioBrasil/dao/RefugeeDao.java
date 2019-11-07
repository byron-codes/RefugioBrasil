package br.com.byron.refugioBrasil.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Refugee;

@Component
public class RefugeeDao extends GenericDao<Refugee> implements IGenericDao<Refugee> {

	@Autowired
	AddressDao addressDao;
	
	@Override
	public Refugee save(Refugee entity) {
		addressDao.save(entity.getAddress());
		return super.save(entity);
	}
	
}
