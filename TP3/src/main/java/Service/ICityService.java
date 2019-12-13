package Service;

import java.util.List;

import Entity.City;

public interface ICityService {
    List<City> searchCity();
    List<City> searchCity(int min, int max);
    int searchMaxId();
    void addCity(int id, String id_city, int id_area, int id_zip, String city_name, String zip_label);
    void subCity(final Integer cityId);
    void updateCity(final List<City> pListCity);
}
