package br.com.byron.refugioBrasil.strategy;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.byron.refugioBrasil.domain.DomainEntity;

@Service
public class RegisterStrategy<Entity extends DomainEntity> implements IStrategy<Entity> {

	@Override
	public String execute(Entity entity) {
		if (entity.getHash() == null && entity.getId() == null) {
			entity.setCreationDate(LocalDateTime.now());
			entity.setLastUpdate(LocalDateTime.now());
			entity.setHash(UUID.randomUUID());
			entity.setStatus(true);
		}
		return null;
	}

}
