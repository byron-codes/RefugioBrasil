package br.com.byron.refugioBrasil.strategy;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Profession;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

@Component
public class CompanyStrategy implements IRefugeeStrategy {

	@Override
	public String execute(Refugee entity) {
		StringBuilder sb = new StringBuilder();
		for(Profession p : entity.getProfessions()) {
			sb.append(ValidUtil.notEmptyandNull(p.getCompany(), "Compania inválida"));
			sb.append(ValidUtil.size(p.getCompany(), "A compania deve ter entre 5 e 100 inválido"));
			sb.append(ValidUtil.notEmptyandNull(p.getWorkload(), "Profissão inválida"));
			sb.append(ValidUtil.size(p.getWorkload(), "A profissão deve ter entre 5 e 100 inválido"));
			sb.append(ValidUtil.notNull(p.getStartDate().toString(), "Data de início inválido"));
			sb.append(ValidUtil.notNull(p.getEndDate().toString(), "Data de fim inválido"));
			sb.append(ValidUtil.notNull(p.getCountry(), "O pais não pode ser nulo"));
			sb.append(ValidUtil.size(p.getDescription(), "descrição"));
		}
		return sb.toString().trim() == "" ? "" : sb.toString();
	}

}
