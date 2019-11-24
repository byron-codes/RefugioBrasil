package br.com.byron.refugioBrasil.strategy.address.validators;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Address;
import br.com.byron.refugioBrasil.strategy.address.IAddressStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

@Component
public class StreetStrategy implements IAddressStrategy{

	@Override
	public String execute(Address entity) {
		StringBuilder sb = new StringBuilder();
		String nameAttribute = "Logradouro";
		sb.append(ValidUtil.size(entity.getStreet(), nameAttribute));
		sb.append(ValidUtil.onlyWords(entity.getStreet(), nameAttribute));
		return sb.toString().trim() == "" ? "" : sb.toString();
	}

}
