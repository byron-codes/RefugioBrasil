package br.com.byron.refugioBrasil.enums;

public enum Operators {

	VIVO("Residêncial"),
	TIM("Celular"),
	CLARO("Comercial"),
	OI("Comercial");
	
	private String description;

	Operators(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
