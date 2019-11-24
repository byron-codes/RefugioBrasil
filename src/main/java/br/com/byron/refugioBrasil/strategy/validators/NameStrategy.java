package br.com.byron.refugioBrasil.strategy.validators;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Dependent;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.dependent.IDependentStrategy;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

@Component
public class NameStrategy implements IRefugeeStrategy, IDependentStrategy {

	@Override
	public String execute(Refugee entity) {
		return valid(entity.getName());
	}

	@Override
	public String execute(Dependent entity) {
		return valid(entity.getName());
	}

	public String valid(String value) {
		StringBuilder sb = new StringBuilder();
		String nameAttribute = "Nome";
		sb.append(ValidUtil.size(value, nameAttribute));
		sb.append(ValidUtil.onlyWords(value, nameAttribute));
		return sb.toString().trim() == "" ? "" : sb.toString();
	}

}
