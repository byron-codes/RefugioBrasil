package br.com.byron.refugioBrasil.enums;

public enum AcademicLevel {
	
	FUNDAMENTAL("Fundamental"),
	MEDIO("Médio"),
	SUPERIOR("Superior"),
	POSGRADUACAO("Pós graduação"),
	MESTRADO("Mestrado"),
	DOUTORADO("Doutorado"),
	POSDOUTORADO("Pós doutorado"),
	LIVREDOCENCIA("Livre docência");
	
	private String description;

	AcademicLevel(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
