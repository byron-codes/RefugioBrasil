package br.com.union.refugioBrasil.command;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.union.refugioBrasil.domain.DomainEntity;
import br.com.union.refugioBrasil.facade.IFacade;

public abstract class AbstractCommand<Entity extends DomainEntity> implements ICommand<Entity> {

	@Autowired
	protected IFacade<Entity> facade;
	
}
