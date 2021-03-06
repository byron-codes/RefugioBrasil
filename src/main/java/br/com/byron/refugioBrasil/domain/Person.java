package br.com.byron.refugioBrasil.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.byron.refugioBrasil.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends DomainEntity {

	@Column(name = "birth_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate bornDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Document> documents = new ArrayList<>();

	@Column(name = "name", length = 100)
	private String name;

}
