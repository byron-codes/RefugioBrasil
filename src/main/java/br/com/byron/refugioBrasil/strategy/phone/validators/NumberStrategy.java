package br.com.byron.refugioBrasil.strategy.phone.validators;

import br.com.byron.refugioBrasil.domain.Phone;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

public class NumberStrategy implements IRefugeeStrategy{

	@Override
	public String execute(Refugee entity) {
		StringBuilder sb = new StringBuilder();
		for(Phone phone : entity.getPhones())
			sb.append(ValidUtil.size(10, 11, phone.getNumber(), "Número"));
		return sb.toString();
	}

}
