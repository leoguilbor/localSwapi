package com.localswapi;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.localswapi.controller.LocalSwapiController;
import com.localswapi.domain.Planet;
import com.localswapi.domain.PlanetApi;
import com.localswapi.repository.PlanetRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalSwapiApplicationTests {

	@Autowired
	LocalSwapiController localSwapiC;
	
	@Autowired
	PlanetRepo planetRepo;
	
	@Test
	public void addPlanet() throws Exception{ //Adicionar um planeta (com nome, clima e terreno)
		planetRepo.deleteAll();
		Planet planet = new Planet("Alderaan", "temperate(L)", "grasslands, mountains(L)");
		assertThat(localSwapiC.insertPlanet(planet))
	      .isEqualTo( ResponseEntity.status(HttpStatus.CREATED).body(planet));
		planetRepo.delete(planet);
	}
	
	@Test
	public void listPlanetsDb() { //Listar planetas do banco de dados
		planetRepo.deleteAll();
		List<Planet> planets = new ArrayList<Planet>();
		planets.add(new Planet("Alderaan", "temperate(L)", "grasslands, mountains(L)"));
		planets.add(new Planet("Yavin IV", "temperate, tropical(L)", "jungle, rainforests(L)"));
		planets.add(new Planet("Hoth", "froze(L)", "tundra, ice caves, mountain ranges(L)"));
		planets.add(new Planet("Dagobah", "murky(L)", "swamp, jungles(L)"));
		
		planets.forEach((p)-> planetRepo.save(p));
		 
		assertThat(localSwapiC.listAllFromDb())
	      .isEqualTo(ResponseEntity.status(HttpStatus.OK).body(planets));	
		
		planetRepo.deleteAll();
	}
	@Test
	public void listPlanetsAPI() throws Exception {//Listar planetas da API do Star Wars
		 String current = new java.io.File( "." ).getCanonicalPath();
	        System.out.println("Current dir:"+current);
		 BufferedReader bufferedReader = new BufferedReader(new FileReader(
	                "./src/test/resource/testData.json"));
		 
		 PlanetApi[] planetsApi = new Gson().fromJson(bufferedReader,PlanetApi[].class);
		 
		assertThat(localSwapiC.listAllFromAPI())
	      .isEqualTo(ResponseEntity.status(HttpStatus.OK).body(Arrays.asList(planetsApi)));
	}
	
	@Test
	public void findPlanetbyName() {//Buscar por nome no banco de dados
		planetRepo.deleteAll();
		ArrayList<Planet> planets = new ArrayList<Planet>();
		planets.add(new Planet("Alderaan", "temperate(L)", "grasslands, mountains(L)"));
		planets.add(new Planet("Yavin IV", "temperate, tropical(L)", "jungle, rainforests(L)"));
		planets.add(new Planet("Hoth", "froze(L)", "tundra, ice caves, mountain ranges(L)"));
		planets.add(new Planet("Dagobah", "murky(L)", "swamp, jungles(L)"));
		
		planets.forEach((p)-> planetRepo.save(p));
		
		ArrayList<Planet> pResponse = new ArrayList<>();
		pResponse.add(planets.get(0));
		
		ResponseEntity<List<Planet>> r = localSwapiC.listFromDbByName("Alderaan");
		
		assertThat(r)
	      .isEqualTo(ResponseEntity.status(HttpStatus.OK).body(pResponse));
		
		planetRepo.deleteAll();
	}
	@Test
	public void findPlanetbyId() {//Buscar por ID no banco de dados
		planetRepo.deleteAll();
		ArrayList<Planet> planets = new ArrayList<Planet>();
		planets.add(new Planet("Alderaan", "temperate(L)", "grasslands, mountains(L)"));
		planets.add(new Planet("Yavin IV", "temperate, tropical(L)", "jungle, rainforests(L)"));
		planets.add(new Planet("Hoth", "froze(L)", "tundra, ice caves, mountain ranges(L)"));
		planets.add(new Planet("Dagobah", "murky(L)", "swamp, jungles(L)"));
		
		planets.forEach((p)-> planetRepo.save(p));
		//planets.forEach((p)-> System.out.println(p.getId()+"---"));
		
		for(Planet pl:planets) {
			assertThat(localSwapiC.listFromDbById(pl.getId()))
		      .isEqualTo(ResponseEntity.status(HttpStatus.OK).body(pl));
		}

		planetRepo.deleteAll();
	}
	
	@Test
	public void removePlanet() {//Remover planeta
		planetRepo.deleteAll();
		Planet newPlanet = planetRepo.save(new Planet("Alderaan", "temperate(L)", "grasslands, mountains(L)")); 
		assertThat(localSwapiC.deletePlanet(newPlanet.getId()))
	    	.isEqualTo(ResponseEntity.status(HttpStatus.OK).build());
		assertThat(planetRepo.findById(newPlanet.getId()))
			.isEqualTo( Optional.empty() );
	}
	

}
