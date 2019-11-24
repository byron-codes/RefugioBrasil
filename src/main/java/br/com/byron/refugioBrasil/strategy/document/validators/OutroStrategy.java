package br.com.byron.refugioBrasil.strategy.document.validators;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Document;
import br.com.byron.refugioBrasil.strategy.document.IDocumentStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

@Component
public class OutroStrategy implements IDocumentStrategy {

	@Override
	public String execute(Document entity) {
		StringBuilder sb = new StringBuilder();
		sb.append(ValidUtil.notEmptyandNull(entity.getNumber(), entity.getType() + " com erro"));
		sb.append(ValidUtil.notSpecials(entity.getNumber(), entity.getType() + " não deve ter caracteres especiais"));
		sb.append(ValidUtil.size(5, 25, entity.getNumber(), entity.getType() + " devem ter entre 5 e 25 número"));
		return sb.toString().trim() == "" ? "" : sb.toString();
	}

}
