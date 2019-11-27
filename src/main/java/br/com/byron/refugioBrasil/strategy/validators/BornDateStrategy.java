package br.com.byron.refugioBrasil.strategy.validators;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Dependent;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.dependent.IDependentStrategy;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

@Component
public class BornDateStrategy implements IRefugeeStrategy, IDependentStrategy {

	@Override
	public String execute(Refugee entity) {
		return valid(entity.getBornDate());
	}

	@Override
	public String execute(Dependent entity) {
		return valid(entity.getBornDate());
	}

	public String valid(LocalDate date) {
		StringBuilder sb = new StringBuilder();

		if (date.isBefore(LocalDate.now().minusYears(100))) {
			sb.append("Data de nascimento inválida");
		}

		if (date.isAfter(LocalDate.now())) {
			sb.append("Data de nascimento inválida");
		}
		return sb.toString().trim() == "" ? "" : sb.toString();
	}

}
