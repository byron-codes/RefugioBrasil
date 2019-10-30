package br.com.byron.refugioBrasil.strategy.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.byron.refugioBrasil.domain.DomainEntity;
import br.com.byron.refugioBrasil.strategy.ILocalStrategy;

@Service
public class RegisterStrategy implements ILocalStrategy<DomainEntity> {

	@Override
	public String execute(DomainEntity entity) {
		entity.setCreationDate(LocalDateTime.now());
		entity.setLastUpdate(LocalDateTime.now());
		entity.setHash(UUID.randomUUID());
		entity.setStatus(true);
		return null;
	}

}
