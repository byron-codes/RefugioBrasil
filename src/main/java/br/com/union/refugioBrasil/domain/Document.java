package br.com.union.refugioBrasil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.union.refugioBrasil.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_document")
public class Document extends DomainEntity {

	@Column(name = "number", length = 25, nullable = false, unique = true)
	private String number;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private DocumentType type;

}
