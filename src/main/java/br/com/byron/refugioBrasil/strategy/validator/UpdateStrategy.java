package br.com.byron.refugioBrasil.strategy.validator;

import java.time.LocalDateTime;

import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

public class UpdateStrategy implements IRefugeeStrategy {

	@Override
	public String execute(Refugee entity) {
		entity.setLastUpdate(LocalDateTime.now());
		return null;
	}

}
