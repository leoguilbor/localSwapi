package com.localswapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.localswapi.domain.PagePlanetApi;
import com.localswapi.domain.Planet;
import com.localswapi.domain.PlanetApi;
import com.localswapi.repository.PlanetRepo;
import com.localswapi.utils.ApiUtils;

@Service
public class PlanetService{

	@Autowired
	PlanetRepo planetRepo;
	public Planet save(Planet planet) throws Exception {
		PagePlanetApi page = ApiUtils.findPlanets(planet.getNome());
	    
		if (page.getCount()>0) {
			planet.setAparicoes(page.getResults().get(0).getFilms().size());
			planet.setRemoteUrl(page.getResults().get(0).getUrl());
		}
		
		return planetRepo.save(planet);
	}
	
	public void delete(Long id) {
		planetRepo.deleteById(id);
	}
	
	public List<Planet> listAllFromDb() {
		

		List<Planet> planets = planetRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
		return  planets;
	}
	
	public List<PlanetApi> listAllFromApi() throws Exception {
		List<PlanetApi> planetsApi = new ArrayList<>();
	
		for (PagePlanetApi p : ApiUtils.listAllPlanets()) {
			planetsApi.addAll(p.getResults());
		}
		
		return planetsApi;
	}

	public List<Planet> listFromDbByName(String name) {
		return planetRepo.findByNome(name);
	}
	@Transactional
	public Planet listFromDbById(Long id) {
		return planetRepo.findById(id).orElse(new Planet());
	}
}
