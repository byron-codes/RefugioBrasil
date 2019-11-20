package br.com.byron.refugioBrasil.strategy.validators;

import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

public class GenderStrategy implements IRefugeeStrategy {

	@Override
	public String execute(Refugee entity) {
		StringBuilder sb = new StringBuilder();
		sb.append(ValidUtil.notNull(entity.getGender()));
		return sb.toString();
	}

}
