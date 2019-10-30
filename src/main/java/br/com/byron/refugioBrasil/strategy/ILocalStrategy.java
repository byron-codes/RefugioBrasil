package br.com.byron.refugioBrasil.strategy;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.DomainEntity;

@Component
public interface ILocalStrategy<Entity extends DomainEntity> {

	public String execute(Entity entity);
	
}
