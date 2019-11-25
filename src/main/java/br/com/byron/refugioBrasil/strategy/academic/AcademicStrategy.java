package br.com.byron.refugioBrasil.strategy.academic;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.byron.refugioBrasil.domain.Academic;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

public class AcademicStrategy implements IRefugeeStrategy{

	Map<String, IAcademicStrategy> validators;
	
	@Autowired
	public AcademicStrategy(Map<String, IAcademicStrategy> validators) {
		this.validators = validators;
	}

	@Override
	public String execute(Refugee entity) {
		StringBuilder sb =  new StringBuilder();
		for(IAcademicStrategy academicStrategy : validators.values()) {
			for(Academic academic : entity.getAcademics()) {
				sb.append(academicStrategy.execute(academic));
			}
		}
			
		return sb.toString().trim() == "" ? "" : sb.toString();
	}
	
	
}
