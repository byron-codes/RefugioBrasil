package br.com.byron.refugioBrasil.enums;

public enum Situation {

	SOCORRO("Socorro"),
	INTEGRACAO("Integração"),
	CONSOLIDACAO("Consolidação");
	
	private String description;

	Situation(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
