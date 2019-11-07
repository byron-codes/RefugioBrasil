package br.com.byron.refugioBrasil.viewHelper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import br.com.byron.refugioBrasil.domain.Document;
import br.com.byron.refugioBrasil.domain.Language;
import br.com.byron.refugioBrasil.domain.Necessity;
import br.com.byron.refugioBrasil.domain.Profession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefugeeVH {
	
	private String email;
	
	private CountryVH birthCountry;
	
	private CountryVH originCountry;
	
	private AddressVH address;

	private MultipartFile file;
	
	private Set<Profession> professions = new HashSet<>();
	
	private Set<Necessity> necessities = new HashSet<>();
	
	private Set<Language> languages = new HashSet<>();
	
	private Set<Document> documents = new HashSet<>();

}
