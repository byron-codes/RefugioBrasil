package br.com.byron.refugioBrasil.viewHelper;

import br.com.byron.refugioBrasil.enums.Category;
import br.com.byron.refugioBrasil.enums.Urgency;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NecessityVH extends GenericVH{
	
	private String description;
	
	private Urgency urgency;
	
	private Category category;
}
