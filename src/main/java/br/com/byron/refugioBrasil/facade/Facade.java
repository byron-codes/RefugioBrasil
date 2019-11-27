package br.com.byron.refugioBrasil.facade;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.dao.IDao;
import br.com.byron.refugioBrasil.domain.DomainEntity;
import br.com.byron.refugioBrasil.strategy.IStrategy;

@Component
public class Facade<Entity extends DomainEntity> implements IFacade<Entity> {

	private final Map<String, IDao<Entity>> dao;

	private final Map<String, IStrategy> mapStrategies;

	@Autowired
	public Facade(Map<String, IDao<Entity>> dao, Map<String, IStrategy> mapStrategies) {
		this.dao = dao;
		this.mapStrategies = mapStrategies;
	}

	@Override
	public List<Entity> save(Entity entity) {

		StringBuilder sb = new StringBuilder();
		sb.append(mapStrategies.get(entity.getClass().getSimpleName().toLowerCase() + "Strategy").execute(entity));
		System.err.println(sb.toString());
		if (sb.length() == 0)
			return Arrays.asList(dao.get(getDaoName(entity)).save(entity));
		return null;
	}

	@Override
	public List<Entity> find(Entity entity) {
		if (entity.getId() == null) {
			return dao.get(getDaoName(entity)).findAll(entity);
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
