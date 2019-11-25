package br.com.byron.refugioBrasil.strategy.address.validators;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Address;
import br.com.byron.refugioBrasil.strategy.address.IAddressStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

@Component
public class CepStrategy implements IAddressStrategy{

	@Override
	public String execute(Address entity) {
		return ValidUtil.size(8, 8, entity.getCep(), "CEP");
	}

}
