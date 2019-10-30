package br.com.byron.refugioBrasil.command;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.byron.refugioBrasil.domain.DomainEntity;
import br.com.byron.refugioBrasil.facade.IFacade;

public abstract class AbstractCommand<Entity extends DomainEntity> implements ICommand<Entity> {

	@Autowired
	protected IFacade<Entity> facade;
	
}
