package br.com.union.refugioBrasil.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.union.refugioBrasil.domain.Refugee;

@Service
public class RefugeeDao extends GenericDao<Refugee> implements IGenericDao<Refugee> {

	@Autowired
	AddressDao addressDao;
	
	@Override
	public Refugee save(Refugee entity) {
		addressDao.save(entity.getAddress());
		return super.save(entity);
	}
	
}