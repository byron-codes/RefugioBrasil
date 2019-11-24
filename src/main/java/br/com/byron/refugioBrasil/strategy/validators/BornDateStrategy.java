package br.com.byron.refugioBrasil.strategy.validators;

import java.time.LocalDate;

import br.com.byron.refugioBrasil.domain.Dependent;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.dependent.IDependentStrategy;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

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
			//TODO
			sb.append("");
		}

		if (date.isAfter(LocalDate.now())) {
			sb.append("");
		}
		return sb.toString().trim() == "" ? "" : sb.toString();
	}

}
