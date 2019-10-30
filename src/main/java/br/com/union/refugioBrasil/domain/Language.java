package br.com.union.refugioBrasil.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.union.refugioBrasil.enums.Fluency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_language")
@AttributeOverride(name = "name", column = @Column(name = "language"))
public class Language extends NamedEntity {

	@Enumerated(EnumType.STRING)
	@Column(name = "fluency",  nullable = false)
	private Fluency fluency;

}
