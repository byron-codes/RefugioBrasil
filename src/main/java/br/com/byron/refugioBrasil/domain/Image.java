package br.com.byron.refugioBrasil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

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
public class Image extends DomainEntity {
	
	@Column(name = "path", nullable = false)
	private String path;
	
	@Column(name = "size", nullable = false)
	private Long size;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Transient
	private MultipartFile file;
	
}
