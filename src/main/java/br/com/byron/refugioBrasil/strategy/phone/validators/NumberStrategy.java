package br.com.byron.refugioBrasil.strategy.phone.validators;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Phone;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

@Component
public class NumberStrategy implements IRefugeeStrategy{

	@Override
	public String execute(Refugee entity) {
		StringBuilder sb = new StringBuilder();
		for(Phone phone : entity.getPhones()) {
			sb.append(ValidUtil.size(8, 9, phone.getNumber(), "Número"));
			sb.append(ValidUtil.size(2, 2, phone.getIdd(), "DDD"));
		}
		return sb.toString().trim() == "" ? "" : sb.toString();
	}

}
