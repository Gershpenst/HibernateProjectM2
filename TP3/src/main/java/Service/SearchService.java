package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.ISearchDAO;
import Entity.Area;
import Entity.City;
import Entity.Country;
import Entity.Street;

@Service
public class SearchService implements ISearchService{
	
	@Autowired
	private ISearchDAO searchDAO;
	
	public void setSearchDAO(ISearchDAO searchDAO) {
		this.searchDAO = searchDAO;
	}
	
	@Transactional(readOnly=true)
	public String searchLanguage(String id_area){
		String langue = searchDAO.searchLanguage(id_area);
		return langue;
	}
	
	@Transactional(readOnly=true)
	public List<Street> searchStreet(){
		List<Street> listStreet = searchDAO.searchStreet();
		return listStreet;
	}
	
	@Transactional(readOnly=true)
	public List<Street> searchStreet(String id_city, String id_area){
		List<Street> listStreet = searchDAO.searchStreet(id_city, id_area);
		return listStreet;
	}
	
	@Transactional(readOnly=true)
	public List<Area> searchArea(){
		List<Area> listArea = searchDAO.searchArea();
		return listArea;
	}
	
	@Transactional(readOnly=true)
	public List<Area> searchArea(String code_iso){
		List<Area> listArea = searchDAO.searchArea(code_iso);
		return listArea;
	}
	
	@Transactional(readOnly=true)
	public List<Country> searchCountry(){
		List<Country> listCountry = searchDAO.searchCountry();
		return listCountry;
	}
	
	@Transactional(readOnly=true)
	public List<City> searchCity(){
		List<City> listCity = searchDAO.searchCity();
		return listCity;
	}
	
	@Transactional(readOnly=true)
	public List<City> searchCity(String id_area){
		List<City> listCity = searchDAO.searchCity(id_area);
		return listCity;
	}
	
}
