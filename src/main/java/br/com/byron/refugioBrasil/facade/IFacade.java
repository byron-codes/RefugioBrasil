package br.com.byron.refugioBrasil.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.DomainEntity;

@Component
public interface IFacade<Entity extends DomainEntity> {

	public List<Entity> save(Entity entity);
	
	public List<Entity> find(Entity entity);
	
	public List<Entity> update(Entity entity);
	
	public List<Entity> delete(Entity entity);
	
}
