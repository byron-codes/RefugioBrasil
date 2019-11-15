package br.com.byron.refugioBrasil.viewHelper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefugeeVH extends GenericVH{
	
	private String email;
	
	private CountryVH birthCountry;
	
	private CountryVH originCountry;
	
	private AddressVH address;

	private MultipartFile file;
	
	private Set<ProfessionVH> professions;
	
	private Set<NecessityVH> necessities = new HashSet<>();
	
	private Set<LanguageVH> languages = new HashSet<>();
	
	private Set<DocumentVH> documents = new HashSet<>();

}
