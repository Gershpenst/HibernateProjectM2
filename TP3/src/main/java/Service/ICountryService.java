package Service;

import java.util.List;

import Entity.Country;

public interface ICountryService {
    List<Country> searchCountries();
    int searchMaxId();
    void addCountry(int identifiant, int id_country, String codeIso);
    void subCountry(final Integer countryId);
    void updateCountries(final List<Country> pListeCourses);
}