package br.com.byron.refugioBrasil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.byron.refugioBrasil.domain.DomainEntity;

public interface IDao<Entity extends DomainEntity> extends JpaRepository<Entity, Long> {

}
