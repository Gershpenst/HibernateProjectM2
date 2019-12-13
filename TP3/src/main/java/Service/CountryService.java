package Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.ICountryDAO;
import Entity.Country;


@Service
public class CountryService implements ICountryService {
   
	@Autowired
    private ICountryDAO countryDAO;
    
	public void setCountryDAO(ICountryDAO countryDAO) {
		this.countryDAO = countryDAO;
	}

    @Transactional(readOnly=true)
    public List<Country> searchCountries() {
    	List<Country> listCountry = countryDAO.searchCountries();
        return listCountry;
    }
    
    @Transactional(readOnly=true)
    public int searchMaxId() {
    	int id = countryDAO.searchMaxId();
        return id;
    }

    @Transactional
	public void addCountry(int identifiant, int id_country, String codeIso) {
		Country country = new Country();
		country.setId(identifiant);
		country.setId_country(id_country);
		country.setCode_iso(codeIso);
		
		countryDAO.addCountry(country);		
    }
    
    @Transactional
    public void subCountry(final Integer IdCountry) {
        final Country lCountry = new Country();
        lCountry.setId(IdCountry);

        countryDAO.subCountry(lCountry);
    }
    
    @Transactional
    public void updateCountries(final List<Country> pListeCountries) {
        for (final Country lCountry : pListeCountries) {
        	countryDAO.updateCountry(lCountry);
        }
    }
}