package br.com.byron.refugioBrasil.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class File extends NamedEntity {

	@Column(name = "origin_name", nullable = true, length = 50)
	protected String originName;

	@Column(name = "size", nullable = false)
	protected Long size;

	@Column(name = "type", nullable = false, length = 5)
	protected String type;

}
