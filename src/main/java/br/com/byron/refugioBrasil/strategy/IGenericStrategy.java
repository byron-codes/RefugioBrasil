package br.com.byron.refugioBrasil.strategy;

import br.com.byron.refugioBrasil.domain.DomainEntity;

public interface IGenericStrategy {
	public String execute(DomainEntity entity);
}
