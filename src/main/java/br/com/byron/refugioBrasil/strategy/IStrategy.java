package br.com.byron.refugioBrasil.strategy;

import br.com.byron.refugioBrasil.domain.IDomain;

public interface IStrategy {
	public String execute(IDomain entity);
}
