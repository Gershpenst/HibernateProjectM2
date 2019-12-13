package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.ICityDAO;
import Entity.City;


@Service
public class CityService implements ICityService{
	@Autowired
	private ICityDAO cityDAO;
	
	public void setCityDAO(ICityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}
	
	@Transactional(readOnly=true)
	public List<City> searchCity(){
		List<City> listCity = cityDAO.searchCity();
		return listCity;
	}
	
	@Transactional(readOnly=true)
	public List<City> searchCity(int min, int max){
		List<City> listCity = cityDAO.searchCity(min, max);
		return listCity;
	}
	
    @Transactional(readOnly=true)
    public int searchMaxId() {
    	int id = cityDAO.searchMaxId();
        return id;
    }
	
    @Transactional
	public void addCity(int id, String id_city, int id_area, int id_zip, String city_name, String zip_label) {
		City city = new City();
		city.setId(id);
		city.setId_city(id_city);
		city.setId_area(id_area);
		city.setId_zip(id_zip);
		city.setCity_name(city_name);
		city.setZip_label(zip_label);
		
		cityDAO.addCity(city);		
    }
    
    @Transactional
    public void subCity(final Integer IdCity) {
        final City lCity = new City();
        lCity.setId(IdCity);

        cityDAO.subCity(lCity);
    }
    
    @Transactional
    public void updateCity(final List<City> pListeCity) {
        for (final City lCity : pListeCity) {
        	cityDAO.updateCity(lCity);
        }
    }

}
