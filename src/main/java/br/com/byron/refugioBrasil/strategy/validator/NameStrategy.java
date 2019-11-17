package br.com.byron.refugioBrasil.strategy.validator;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

@Component
public class NameStrategy implements IRefugeeStrategy {

	@Override
	public String execute(Refugee entity) {
		return null;
	}

}
