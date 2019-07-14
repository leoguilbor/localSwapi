package com.localswapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.localswapi.domain.Planet;
import com.localswapi.domain.PlanetApi;
import com.localswapi.service.PlanetService;

@RestController
@RequestMapping("/api")
public class LocalSwapiController {
	@Autowired
	PlanetService planetService;


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePlanet(@PathVariable("id") Long id) {
		planetService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/insert/")
	public ResponseEntity<Planet> insertPlanet(@RequestBody Planet planet) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(planetService.save(planet));
	}
	@GetMapping({"/planets/","/planets/db"})
	public ResponseEntity<List<Planet>> listAllFromDb() {
		return ResponseEntity.status(HttpStatus.OK).body(planetService.listAllFromDb());
	}
	@GetMapping("/planets/api")
	public ResponseEntity<List<PlanetApi>> listAllFromAPI() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(planetService.listAllFromApi());
	}
	@GetMapping("/planets/name/{name}")
	public ResponseEntity<List<Planet>> listFromDbByName(@PathVariable String nome) {
		return ResponseEntity.status(HttpStatus.OK).body(planetService.listFromDbByName(nome));
	}
	@GetMapping("/planets/id/{id}")
	public ResponseEntity<Planet> listFromDbById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(planetService.listFromDbById(id));
	}
	
}
