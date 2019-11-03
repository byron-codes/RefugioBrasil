package br.com.byron.refugioBrasil.strategy;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.IDomain;

@Component
public interface IStrategy {
	
	public String execute(IDomain entity);
	
}
