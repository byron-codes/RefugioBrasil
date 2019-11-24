package br.com.byron.refugioBrasil.strategy.necessity;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

@Component
public class NecessityStrategy implements IRefugeeStrategy {

	@Override
	public String execute(Refugee entity) {
		StringBuilder sb = new StringBuilder();
		sb.append(ValidUtil.notEmptyandNull(entity.getNecessity().getSituation().getDescription(), "Situação inválida"));
		sb.append(ValidUtil.notEmptyandNull(entity.getNecessity().getDescription(), "Observação inválida"));
		sb.append(ValidUtil.size(entity.getNecessity().getDescription(), "Observação inválida"));
		return null;
	}

}
