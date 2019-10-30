package br.com.byron.refugioBrasil.enums;

public enum MaritalStatus {

	SOLTEIRO("Solteiro"),
	CASADO("Casado"),
	SEPARADO("Separado"),
	DIVORCIADO("Divorciado"),
	VIUVO("Viúvo");
	
	private String description;

	MaritalStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
