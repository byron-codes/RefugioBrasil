package br.com.byron.refugioBrasil.strategy.academic.validator;

import br.com.byron.refugioBrasil.domain.Academic;
import br.com.byron.refugioBrasil.strategy.academic.IAcademicStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

public class InstituationStrategy implements IAcademicStrategy{

	@Override
	public String execute(Academic entity) {
		return ValidUtil.size(entity.getInstituation(), "Instituição");
	}

}
