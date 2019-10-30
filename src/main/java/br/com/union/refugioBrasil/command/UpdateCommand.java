package br.com.union.refugioBrasil.command;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.union.refugioBrasil.domain.DomainEntity;

@Service
public class UpdateCommand<Entity extends DomainEntity> extends AbstractCommand<Entity> {

	@Override
	public List<Entity> execute(Entity entity) {
		return facade.update(entity);
	}

}
