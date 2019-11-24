package br.com.byron.refugioBrasil.strategy.validators;

import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

public class MaritalStatusStrategy implements IRefugeeStrategy{

	@Override
	public String execute(Refugee entity) {
		return ValidUtil.notEmptyandNull(entity.getMaritalStatus().getDescription(), "Estado civíl inválido");
	}

}
