package br.com.byron.refugioBrasil.strategy.academic.validator;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Academic;
import br.com.byron.refugioBrasil.strategy.academic.IAcademicStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

@Component
public class RequeredAcademicStrategy implements IAcademicStrategy{

	@Override
	public String execute(Academic entity) {
		StringBuilder sb = new StringBuilder();
		sb.append(ValidUtil.notEmptyandNull(entity.getCourse(), "Curso"));
		sb.append(ValidUtil.notNull(entity.getInstituation(), "Instituição"));
		sb.append(ValidUtil.notNull(entity.getStartDate(), "Data de início"));
		sb.append(ValidUtil.notNull(entity.getEndDate(), "Data de fim"));
		sb.append(ValidUtil.notNull(entity.getLevel(), "Grau academico"));
		sb.append(ValidUtil.notNull(entity.getCountry(), "País de formação"));
		sb.append(ValidUtil.notNull(entity.getSituation(), "Situação da formação"));

		return sb.toString().trim() == "" ? "" : sb.toString();
	}

}
