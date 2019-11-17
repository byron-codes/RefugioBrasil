package br.com.byron.refugioBrasil.strategy.refugee;

import br.com.byron.refugioBrasil.domain.Refugee;

public interface IRefugeeStrategy{
	public String execute(Refugee entity);
}
