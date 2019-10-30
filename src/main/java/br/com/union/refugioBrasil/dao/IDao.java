package br.com.union.refugioBrasil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.union.refugioBrasil.domain.DomainEntity;

public interface IDao<Entity extends DomainEntity> extends JpaRepository<Entity, Long> {

}
