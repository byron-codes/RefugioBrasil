package br.com.byron.refugioBrasil.strategy.adress.validators;

import br.com.byron.refugioBrasil.domain.Address;
import br.com.byron.refugioBrasil.strategy.adress.IAddressStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

public class RequiredAddressStrategy implements IAddressStrategy {

	@Override
	public String execute(Address entity) {
		StringBuilder sb =  new StringBuilder();

		sb.append(ValidUtil.notEmptyandNull(entity.getCep(), "Tipo moradia"));
		sb.append(ValidUtil.notEmptyandNull(entity.getComplement(), "Complemento"));
		sb.append(ValidUtil.notEmptyandNull(entity.getStreet(), "Logradouro"));
		
		sb.append(ValidUtil.notNull(entity.getHomeType(), "Tipo moradia"));
		sb.append(ValidUtil.notNull(entity.getCity(), "Cidade"));
		sb.append(ValidUtil.notNull(entity.getNumber(), "Número"));
		
		return sb.toString();
	}

}
