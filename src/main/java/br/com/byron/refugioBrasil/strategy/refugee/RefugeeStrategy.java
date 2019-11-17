package br.com.byron.refugioBrasil.strategy.refugee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.IDomain;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.IStrategy;

@Component
public class RefugeeStrategy implements IStrategy {

	private final List<IRefugeeStrategy> validators;

	@Autowired
	public RefugeeStrategy(List<IRefugeeStrategy> validators) {
		this.validators = validators;
	}

	@Override
	public String execute(IDomain entity) {
		StringBuilder errors = new StringBuilder();
		for (IRefugeeStrategy strategy : validators)
			errors.append(strategy.execute((Refugee) entity));

		return errors.toString();
	}

}
