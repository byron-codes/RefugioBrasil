package br.com.union.refugioBrasil.strategy;

import org.springframework.stereotype.Component;

import br.com.union.refugioBrasil.domain.DomainEntity;

@Component
public interface IStrategy<Entity extends DomainEntity> {

	public String execute(Entity entity);

}
