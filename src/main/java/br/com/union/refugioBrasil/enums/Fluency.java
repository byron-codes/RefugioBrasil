package br.com.union.refugioBrasil.enums;

public enum Fluency {

	BASICO("Básico"), 
	INTERMEDIARIO("Intermediário"), 
	AVANCADO("Avançado"), 
	FLUENTE("Fluente");

	private String description;

	Fluency(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
