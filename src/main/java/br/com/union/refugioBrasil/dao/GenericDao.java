package br.com.union.refugioBrasil.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.union.refugioBrasil.domain.DomainEntity;

public class GenericDao<Entity extends DomainEntity> implements IGenericDao<Entity> {

	@Autowired
	IDao<Entity> dao;

	@Override
	public Entity save(Entity entity) {
		entity.setCreationDate(LocalDateTime.now());
		entity.setLastUpdate(LocalDateTime.now());
		entity.setHash(UUID.randomUUID());
		entity.setStatus(true);
		return dao.saveAndFlush(entity);
	}

	@Override
	public Entity update(Entity entity) {
		entity.setLastUpdate(LocalDateTime.now());
		return dao.saveAndFlush(entity);
	}

	@Override
	public Entity find(Entity entity) {
		Optional<Entity> returnEntity = dao.findById(entity.getId());
		if(returnEntity != null && returnEntity.isPresent() && returnEntity.get().getStatus()) {
			return returnEntity.get();
		}
		return null;
	}

	@Override
	public List<Entity> findAll() {
		List<Entity> entities = new ArrayList<Entity>();
		for (Entity entityA : dao.findAll()) {
			if (entityA.getStatus()) {
				entities.add(entityA);
			}
		}
		return entities;
	}

	@Override
	public Entity delete(Entity entity) {
		entity.setStatus(false);
		return dao.saveAndFlush(entity);
	}

}
