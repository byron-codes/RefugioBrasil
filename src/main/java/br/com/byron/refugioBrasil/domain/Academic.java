package br.com.byron.refugioBrasil.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.byron.refugioBrasil.enums.AcademicLevel;
import br.com.byron.refugioBrasil.enums.AcademicStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_academic")
public class Academic extends DomainEntity {
	
	@Column(name = "course", length = 100)
	private String course;
	
	@Column(name = "instituation", length = 100)
	private String instituation;

	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	@Column(name = "end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "level", nullable = false)
	private AcademicLevel level;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "situation", nullable = false)
	private AcademicStatus situation;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "country")
	private Country country;

}
