package br.com.union.refugioBrasil.enums;

public enum PhoneType {
	
	RESIDENCIAL("Residêncial"),
	CELULAR("Celular"),
	COMERCIAL("Comercial");
	
	private String description;

	PhoneType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
