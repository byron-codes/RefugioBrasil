package br.com.byron.refugioBrasil.strategy.validators;

import java.time.LocalDateTime;

import br.com.byron.refugioBrasil.domain.DomainEntity;
import br.com.byron.refugioBrasil.strategy.IGenericStrategy;

public class UpdateStrategy implements IGenericStrategy<DomainEntity> {

	@Override
	public String execute(DomainEntity entity) {
		entity.setLastUpdate(LocalDateTime.now());
		return "";
	}

}
