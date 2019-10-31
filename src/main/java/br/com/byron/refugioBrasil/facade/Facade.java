package br.com.byron.refugioBrasil.facade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.byron.refugioBrasil.dao.IGenericDao;
import br.com.byron.refugioBrasil.domain.DomainEntity;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.IStrategy;
import br.com.byron.refugioBrasil.strategy.RefugeeDocumentStrategy;
import br.com.byron.refugioBrasil.strategy.RegisterStrategy;
import br.com.byron.refugioBrasil.strategy.UpdateStrategy;

@Service
public class Facade<Entity extends DomainEntity> implements IFacade<Entity> {

	private final Map<String, IGenericDao<Entity>> dao;

	private final Map<String, List<IStrategy<Entity>>> strategy;

	@Autowired
	public Facade(Map<String, IGenericDao<Entity>> dao) {
		this.dao = dao;
		this.strategy = new HashMap<String, List<IStrategy<Entity>>>();
		
		List<IStrategy<Entity>> refugee = new ArrayList<IStrategy<Entity>>(); 
		refugee.add(new RegisterStrategy<Entity>());
		refugee.add(new UpdateStrategy<Entity>());
		refugee.add(new RefugeeDocumentStrategy<Entity>());
		
		strategy.put(Refugee.class.getSimpleName(), refugee);
	}

	@Override
	public List<Entity> save(Entity entity) {
		StringBuilder sb = new StringBuilder();
		for(IStrategy<Entity> strategy : strategy.get(entity.getClass().getSimpleName())) {
			sb.append(strategy.execute(entity));
		}
		return Arrays.asList(dao.get(getDaoName(entity)).save(entity));
	}

	@Override
	public List<Entity> find(Entity entity) {
		if (entity.getId() != null) {
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
