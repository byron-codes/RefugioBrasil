package br.com.byron.refugioBrasil.strategy.phone.validators;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Phone;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

@Component
public class RequeredPhoneStrategy implements IRefugeeStrategy{

	@Override
	public String execute(Refugee entity) {
		StringBuilder sb = new StringBuilder();
		for(Phone phone : entity.getPhones()) {
			sb.append(ValidUtil.notNull(phone.getOperators(), "Operadora"));
			sb.append(ValidUtil.notEmptyandNull(phone.getIdd(), "DDD"));
			sb.append(ValidUtil.notEmptyandNull(phone.getNumber(), "Número"));
			sb.append(ValidUtil.notNull(phone.getType(), "Tipo do Telefone"));
		}
		return sb.toString().trim() == "" ? "" : sb.toString();
	}

}
