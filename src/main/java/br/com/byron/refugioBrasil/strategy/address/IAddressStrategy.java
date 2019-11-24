package br.com.byron.refugioBrasil.strategy.address;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Address;
import br.com.byron.refugioBrasil.strategy.IGenericStrategy;

@Component
public interface IAddressStrategy extends IGenericStrategy<Address> {
}
