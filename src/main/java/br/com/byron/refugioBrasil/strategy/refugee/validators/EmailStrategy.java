package br.com.byron.refugioBrasil.strategy.refugee.validators;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

@Component
public class EmailStrategy implements IRefugeeStrategy {

	@Override
	public String execute(Refugee entity) {
		StringBuilder sb = new StringBuilder();
//		sb.append(ValidUtil.validEmail(entity.getEmail()));
		return sb.toString().trim() == "" ? "" : sb.toString();
	}

}
