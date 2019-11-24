package br.com.byron.refugioBrasil.strategy.adress.validators;

import br.com.byron.refugioBrasil.domain.Address;
import br.com.byron.refugioBrasil.strategy.adress.IAddressStrategy;
import br.com.byron.refugioBrasil.strategy.validators.ValidUtil;

public class CepStrategy implements IAddressStrategy{

	@Override
	public String execute(Address entity) {
		return ValidUtil.size(entity.getCep(), "CEP");
	}

}
