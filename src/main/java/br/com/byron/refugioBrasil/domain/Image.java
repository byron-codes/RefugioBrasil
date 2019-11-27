package br.com.byron.refugioBrasil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_image")
public class Image extends File {

	@Column(name = "description",  nullable = true)
	private String description;
	
	@Column(name = "heigth",  nullable = true)
	private Double heigth;
	
	@Column(name = "width",  nullable = true)
	private Double width;
	
	@Transient
	private String file;
	
}
