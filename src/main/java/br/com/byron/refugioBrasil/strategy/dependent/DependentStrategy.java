package br.com.byron.refugioBrasil.strategy.dependent;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.byron.refugioBrasil.domain.Dependent;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

public class DependentStrategy implements IRefugeeStrategy {

	Map<String, IDependentStrategy> validators;

	@Autowired
	public DependentStrategy(Map<String, IDependentStrategy> validators) {
		this.validators = validators;
	}

	@Override
	public String execute(Refugee entity) {
		StringBuilder sb = new StringBuilder();
		for(IDependentStrategy valid : validators.values()) {
			for(Dependent dependent : entity.getDependent()) {
				sb.append(valid.execute(dependent));
			}
		}
		return sb.toString();
	}

}
