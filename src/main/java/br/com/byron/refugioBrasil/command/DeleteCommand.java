package br.com.byron.refugioBrasil.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.byron.refugioBrasil.domain.DomainEntity;

@Service
public class DeleteCommand<Entity extends DomainEntity> extends AbstractCommand<Entity> {

	@Override
	public List<Entity> execute(Entity entity) {
		facade.delete(entity);
		return new ArrayList<Entity>();
	}

}
