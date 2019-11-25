package br.com.byron.refugioBrasil.strategy.validators;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

@Component
public class BornCountryStrategy implements IRefugeeStrategy{

	@Override
	public String execute(Refugee entity) {
		return ValidUtil.notEmptyandNull(entity.getBornDate().toString(), "Data de nascimento inválida");
	}

}
