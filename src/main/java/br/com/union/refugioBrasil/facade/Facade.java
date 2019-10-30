package br.com.union.refugioBrasil.facade;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.union.refugioBrasil.dao.IGenericDao;
import br.com.union.refugioBrasil.domain.DomainEntity;

@Service
public class Facade<Entity extends DomainEntity> implements IFacade<Entity> {

	private final Map<String, IGenericDao<Entity>> dao;
		
	@Autowired
	public Facade(Map<String, IGenericDao<Entity>> dao) {
		this.dao = dao;
	}

	@Override
	public List<Entity> save(Entity entity) {
		return Arrays.asList(dao.get(getDaoName(entity)).save(entity));
	}
	
	@Override
	public List<Entity> find(Entity entity) {
		if(entity.getId() != null) {
			return dao.get(getDaoName(entity)).findAll();
		} else {
			return Arrays.asList(dao.get(getDaoName(entity)).find(entity));
		}
	}

	@Override
	public List<Entity> update(Entity entity) {
		return Arrays.asList(dao.get(getDaoName(entity)).update(entity));
	}

	@Override
	public List<Entity> delete(Entity entity) {
		return Arrays.asList(dao.get(getDaoName(entity)).delete(entity));
	}
	
	private String getDaoName(Entity entity) {
		return entity.getClass().getSimpleName().toLowerCase() + "Dao";
	}

}