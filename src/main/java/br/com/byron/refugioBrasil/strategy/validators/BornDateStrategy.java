package br.com.byron.refugioBrasil.strategy.validators;

import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

public class BornDateStrategy implements IRefugeeStrategy{

	@Override
	public String execute(Refugee entity) {
		StringBuilder sb = new StringBuilder();
		sb.append(ValidUtil.notEmptyandNull(entity.getBirthDate().toString()));
		return null;
		
	}

}
