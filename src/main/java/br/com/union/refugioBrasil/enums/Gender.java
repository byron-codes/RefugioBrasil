package br.com.union.refugioBrasil.enums;

public enum Gender {

	MASCULINO("Masculino"), 
	FEMININO("Feminino"), 
	NAOBINARIO("Não binario");

	private String description;

	Gender(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
