package br.com.byron.refugioBrasil.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.DomainEntity;

@Component
public interface IDao<Entity extends DomainEntity> {

	public Entity save(Entity entity);
	
	public Entity update(Entity entity);
	
	public Entity find(Entity entity);
	
	public List<Entity> findAll(Entity entity);
	
	public Entity delete(Entity entity);
	
}
