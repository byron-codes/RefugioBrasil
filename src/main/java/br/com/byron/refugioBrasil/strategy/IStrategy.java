package br.com.byron.refugioBrasil.strategy;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.DomainEntity;

@Component
public interface IStrategy<Entity extends DomainEntity> {
	
	public String save(Entity entity);
	
	public String update(Entity entity);
	
	public String read(Entity entity);
	
	public String delete(Entity entity);

}
