package br.com.byron.refugioBrasil.viewHelper;

import br.com.byron.refugioBrasil.enums.HomeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressVH extends GenericVH{
	
	private String street;

	private int number;

	private String complement;

	private String cep;

	private String city;

	private String state;

	private HomeType homeType;
}
