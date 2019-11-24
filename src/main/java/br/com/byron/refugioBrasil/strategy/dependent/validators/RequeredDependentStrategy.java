package br.com.byron.refugioBrasil.strategy.dependent.validators;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Dependent;
import br.com.byron.refugioBrasil.strategy.dependent.IDependentStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

@Component
public class RequeredDependentStrategy implements IDependentStrategy {

	@Override
	public String execute(Dependent entity) {
		StringBuilder sb = new StringBuilder();
		sb.append(ValidUtil.notEmptyandNull(entity.getName(), "Nome"));
		sb.append(ValidUtil.notNull(entity.getGender(), "Sexo"));
		sb.append(ValidUtil.notNull(entity.getKinship(), "Parentesco"));
		sb.append(ValidUtil.notNull(entity.getBornDate(), "Data de Nascimento"));
		sb.append(ValidUtil.notNull(entity.getArrivalDate(), "Data de Nascimento"));
		sb.append(ValidUtil.notNull(entity.getBirthCountry(), "País de Nascimento"));

		return sb.toString().trim() == "" ? "" : sb.toString();
	}

}
