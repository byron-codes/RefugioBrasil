package br.com.byron.refugioBrasil.strategy.validators;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

@Component
public class NameStrategy implements IRefugeeStrategy {

	@Override
	public String execute(Refugee entity) {
		StringBuilder sb = new StringBuilder();
		sb.append(ValidUtil.notEmptyandNull(entity.getName()));
		sb.append(ValidUtil.size(5, 100, entity.getName()));
		sb.append(ValidUtil.onlyWords(entity.getName()));
		return sb.toString();
	}

}
