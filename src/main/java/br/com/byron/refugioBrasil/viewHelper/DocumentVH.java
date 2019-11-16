package br.com.byron.refugioBrasil.viewHelper;

import br.com.byron.refugioBrasil.enums.DocumentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentVH extends GenericVH{
	private String number;
	private DocumentType type;
}
