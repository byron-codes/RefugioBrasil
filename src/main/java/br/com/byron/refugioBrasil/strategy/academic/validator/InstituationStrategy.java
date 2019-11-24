package br.com.byron.refugioBrasil.strategy.academic.validator;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Academic;
import br.com.byron.refugioBrasil.strategy.academic.IAcademicStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

@Component
public class InstituationStrategy implements IAcademicStrategy{

	@Override
	public String execute(Academic entity) {
		return ValidUtil.size(entity.getInstituation(), "Instituição");
	}

}
