package br.com.byron.refugioBrasil.strategy.domain;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.com.byron.refugioBrasil.domain.DomainEntity;
import br.com.byron.refugioBrasil.strategy.ILocalStrategy;

@Service
public class UpdateStrategy implements ILocalStrategy<DomainEntity> {

	@Override
	public String execute(DomainEntity entity) {
		entity.setLastUpdate(LocalDateTime.now());
		return null;
	}

}
