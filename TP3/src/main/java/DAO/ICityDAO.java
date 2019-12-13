package DAO;

import java.util.List;

import Entity.City;

public interface ICityDAO {
	List<City> searchCity();
	List<City> searchCity(int min, int max);
	int searchMaxId();
    void addCity(City city);
    void subCity(final City city);
    void updateCity(final City city);
}
