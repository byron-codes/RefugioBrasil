package br.com.byron.refugioBrasil.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import br.com.byron.refugioBrasil.config.ConversorUUIDString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class DomainEntity implements IDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "hash", nullable = false, unique = true, updatable = false)
	@Convert(converter = ConversorUUIDString.class)
	private UUID hash;

	@Column(name = "status", nullable = false)
	private Boolean status;

	@Column(name = "creation_date", nullable = false, updatable = false)
	private LocalDateTime creationDate;

	@Column(name = "last_update", nullable = false)
	private LocalDateTime lastUpdate;

}
