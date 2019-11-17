package br.com.byron.refugioBrasil.strategy.validator;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.DomainEntity;
import br.com.byron.refugioBrasil.strategy.IGenericStrategy;

@Component
public class CreateStrategy implements IGenericStrategy {

	@Override
	public String execute(DomainEntity entity) {
		entity.setCreationDate(LocalDateTime.now());
		entity.setLastUpdate(LocalDateTime.now());
		entity.setStatus(true);
		return null;
	}

}
