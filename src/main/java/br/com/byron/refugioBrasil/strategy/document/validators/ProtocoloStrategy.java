package br.com.byron.refugioBrasil.strategy.document.validators;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Document;
import br.com.byron.refugioBrasil.strategy.document.IDocumentStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

@Component
public class ProtocoloStrategy implements IDocumentStrategy {

	@Override
	public String execute(Document entity) {
		StringBuilder sb = new StringBuilder();
		sb.append(ValidUtil.notEmptyandNull(entity.getNumber(), entity.getType() + " com erro"));
		sb.append(ValidUtil.onlyNumbers(entity.getNumber(), entity.getType() + " devem ter apenas número"));
		sb.append(ValidUtil.size(17, 17, entity.getNumber(), entity.getType() + " devem ter 17 número"));
		return sb.toString().trim() == "" ? "" : sb.toString();
	}

}
