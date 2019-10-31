package br.com.byron.refugioBrasil.strategy;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.com.byron.refugioBrasil.domain.DomainEntity;

@Service
public class UpdateStrategy<Entity extends DomainEntity> implements IStrategy<Entity> {

	@Override
	public String execute(Entity entity) {
		entity.setLastUpdate(LocalDateTime.now());
		return null;
	}

}
