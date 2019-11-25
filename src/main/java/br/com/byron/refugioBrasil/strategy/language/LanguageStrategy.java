package br.com.byron.refugioBrasil.strategy.language;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Language;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

@Component
public class LanguageStrategy implements IRefugeeStrategy {

	@Override
	public String execute(Refugee entity) {
		StringBuilder sb = new StringBuilder();
		for(Language l : entity.getLanguages()) {
			sb.append(ValidUtil.notEmptyandNull(l.getFluency().getDescription(), "Fluência inválida"));
			sb.append(ValidUtil.notEmptyandNull(l.getName(), "Língua inválida"));
		}
		return sb.toString().trim() == "" ? "" : sb.toString();
	}

}
