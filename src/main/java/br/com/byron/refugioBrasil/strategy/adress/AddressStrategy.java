package br.com.byron.refugioBrasil.strategy.adress;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

@Component
public class AddressStrategy implements IRefugeeStrategy {

	Map<String, IAddressStrategy> validators;

	@Autowired
	AddressStrategy(Map<String, IAddressStrategy> validators) {
		this.validators = validators;
	}

	@Override
	public String execute(Refugee entity) {
		StringBuilder sb = new StringBuilder();

		for (IAddressStrategy a : validators.values())
			sb.append(a.execute(entity.getAddress()));

		return sb.toString();
	}

}
