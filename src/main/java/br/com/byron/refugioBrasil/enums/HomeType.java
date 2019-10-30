package br.com.byron.refugioBrasil.enums;

public enum HomeType {

	PROPRIA("Própria"),
	ALUGADA("Alugada"),
	AUXILIO("Auxilio governamental"),
	OUTRO("Outro");
	
	private String description;

	HomeType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
