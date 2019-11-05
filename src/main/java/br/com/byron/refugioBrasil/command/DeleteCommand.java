package br.com.byron.refugioBrasil.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.DomainEntity;

@Component
public class DeleteCommand<Entity extends DomainEntity> extends AbstractCommand<Entity> {

	@Override
	public List<Entity> execute(Entity entity) {
		facade.delete(entity);
		return new ArrayList<Entity>();
	}

}
