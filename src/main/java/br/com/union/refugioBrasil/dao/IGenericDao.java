package br.com.union.refugioBrasil.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.union.refugioBrasil.domain.DomainEntity;

@Component
public interface IGenericDao<Entity extends DomainEntity> {

	public Entity save(Entity entity);
	
	public Entity update(Entity entity);
	
	public Entity find(Entity entity);
	
	public List<Entity> findAll();
	
	public Entity delete(Entity entity);
	
}
