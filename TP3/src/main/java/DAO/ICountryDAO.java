package DAO;

import java.util.List;

import Entity.Country;


public interface ICountryDAO {
    List<Country> searchCountries();
    int searchMaxId();
    void addCountry(Country country);
    void subCountry(final Country country);
    void updateCountry(final Country country);
}