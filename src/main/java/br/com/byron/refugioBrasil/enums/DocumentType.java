package br.com.byron.refugioBrasil.enums;

public enum DocumentType {

	PROTOCOLO("Protocolo"), 
	RNM("RNM"),
	CPF("CPF"), 
	RG("RG"), 
	PASSAPORTE("Passaporte"), 
	CNH("CNH"),
	PIS("PIS"), 
	CARTEIRADETRABALHO("Carteira de trabalho");

	private String description;

	DocumentType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
