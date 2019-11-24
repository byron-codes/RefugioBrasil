package br.com.byron.refugioBrasil.strategy.phone;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.byron.refugioBrasil.domain.Phone;
import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

public class PhoneStrategy implements IRefugeeStrategy{

	Map<String, IPhoneStrategy> validators;
	
	@Autowired
	public PhoneStrategy(Map<String, IPhoneStrategy> validators){
		this.validators = validators;
	}
	
	@Override
	public String execute(Refugee entity) {
		StringBuilder sb = new StringBuilder();
		for(IPhoneStrategy validator : validators.values()) {
			for(Phone phone : entity.getPhones())
				sb.append(validator.execute(phone));
		}
		return sb.toString().trim() == "" ? "" : sb.toString();
	}

}
