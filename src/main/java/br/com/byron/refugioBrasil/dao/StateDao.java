package br.com.byron.refugioBrasil.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.State;

@Component
public class StateDao implements IDao<State> {

	@Autowired
	IStateDao dao;
	
	@Override
	public State save(State entity) {
		return dao.saveAndFlush(entity);
	}

	@Override
	public State update(State entity) {
		entity.setLastUpdate(LocalDateTime.now());
		return dao.saveAndFlush(entity);
	}

	@Override
	public State find(State entity) {
		Optional<State> returnEntity = dao.findById(entity.getId());
		if(returnEntity != null && returnEntity.isPresent() && returnEntity.get().getStatus()) {
			return returnEntity.get();
		}
		return null;
	}

	@Override
	public List<State> findAll(State entity) {
		List<State> entities = new ArrayList<State>();
		for (State entityA : dao.findAll()) {
			if (entityA.getStatus()) {
				entities.add(entityA);
			}
		}
		return entities;
	}

	@Override
	public State delete(State entity) {
		entity.setStatus(false);
		return dao.saveAndFlush(entity);
	}
	
}
