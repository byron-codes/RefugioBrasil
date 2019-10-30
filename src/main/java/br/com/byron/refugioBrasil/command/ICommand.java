package br.com.byron.refugioBrasil.command;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.DomainEntity;

@Component
public interface ICommand<Entity extends DomainEntity> {
	
	public List<Entity> execute(Entity entity);

}
