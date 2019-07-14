package com.localswapi.domain;

import java.util.List;

public class PlanetApi {
	private String name;//-- The name of this planet.
	private String diameter;//-- The diameter of this planet in kilometers.
	private String rotation_period;//-- The number of standard hours it takes for this planet to complete a single rotation on its axis.
	private String orbital_period;//-- The number of standard days it takes for this planet to complete a single orbit of its local star.
	private String gravity;//-- A number denoting the gravity of this planet, where "1" is normal or 1 standard G. "2" is twice or 2 standard Gs. "0.5" is half or 0.5 standard Gs.
	private String population;//-- The average population of sentient beings inhabiting this planet.
	private String climate;//-- The climate of this planet. Comma separated if diverse.
	private String terrain;//-- The terrain of this planet. Comma separated if diverse.
	private String surface_water;//-- The percentage of the planet surface that is naturally occurring water or bodies of water.
	private List<String> residents; //-- An array of People URL Resources that live on this planet.
	private List<String> films; //-- An array of Film URL Resources that this planet has appeared in.
	private String url;//-- the hypermedia URL of this resource.
	private String created;//-- the ISO 8601 date format of the time that this resource was created.
	private String edited;//-- the ISO 8601 date format of the time that this resource was updated.
	
	public PlanetApi() {
		super();
	}

	public PlanetApi(String name, String diameter, String rotation_period, String orbital_period, String gravity,
			String population, String climate, String terrain, String surface_water, List<String> residents,
			List<String> films, String url, String created, String edited) {
		super();
		this.name = name;
		this.diameter = diameter;
		this.rotation_period = rotation_period;
		this.orbital_period = orbital_period;
		this.gravity = gravity;
		this.population = population;
		this.climate = climate;
		this.terrain = terrain;
		this.surface_water = surface_water;
		this.residents = residents;
		this.films = films;
		this.url = url;
		this.created = created;
		this.edited = edited;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiameter() {
		return diameter;
	}

	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}

	public String getRotation_period() {
		return rotation_period;
	}

	public void setRotation_period(String rotation_period) {
		this.rotation_period = rotation_period;
	}

	public String getOrbital_period() {
		return orbital_period;
	}

	public void setOrbital_period(String orbital_period) {
		this.orbital_period = orbital_period;
	}

	public String getGravity() {
		return gravity;
	}

	public void setGravity(String gravity) {
		this.gravity = gravity;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public String getSurface_water() {
		return surface_water;
	}

	public void setSurface_water(String surface_water) {
		this.surface_water = surface_water;
	}

	public List<String> getResidents() {
		return residents;
	}

	public void setResidents(List<String> residents) {
		this.residents = residents;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanetApi other = (PlanetApi) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
