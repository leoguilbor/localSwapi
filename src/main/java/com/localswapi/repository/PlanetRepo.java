package com.localswapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.localswapi.domain.Planet;

public interface PlanetRepo extends JpaRepository<Planet, Long> {

	List<Planet> findByNome(String name);

}
