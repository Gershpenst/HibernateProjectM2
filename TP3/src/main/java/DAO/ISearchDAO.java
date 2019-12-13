package DAO;

import java.util.List;

import Entity.Area;
import Entity.City;
import Entity.Country;
import Entity.Street;

public interface ISearchDAO {
	List<Street> searchStreet();
	List<Street> searchStreet(String id_city, String id_area);
	List<Area> searchArea();
	List<Area> searchArea(String code_iso);
	List<Country> searchCountry();
	List<City> searchCity();
	List<City> searchCity(String id_area);
	String searchLanguage(String id_area);
}
