package br.com.union.refugioBrasil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.union.refugioBrasil.enums.Category;
import br.com.union.refugioBrasil.enums.Urgency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_necessity")
public class Necessity extends DomainEntity {
	
	@Column(name = "description", length = 150, nullable = false)
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "urgency", nullable = false)
	private Urgency urgency;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "category", nullable = false)
	private Category category;

}
