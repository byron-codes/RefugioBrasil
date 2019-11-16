package br.com.byron.refugioBrasil.enums;

public enum AcademicStatus {
	
	CURSANDO("Cursando"),
	COMPLETO("Completo"),
	INCOMPLETO("Incompleto");
	
	private String description;

	AcademicStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
