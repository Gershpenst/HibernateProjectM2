package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.IStreetDAO;
import Entity.Street;

@Service
public class StreetService implements IStreetService{
	
	@Autowired
	private IStreetDAO streetDAO;
	
	public void setStreetDAO(IStreetDAO streetDAO) {
		this.streetDAO = streetDAO;
	}
	
	@Transactional(readOnly=true)
	public List<Street> searchStreet(){
		List<Street> listStreet = streetDAO.searchStreet();
		return listStreet;
	}
	
    @Transactional(readOnly=true)
    public int searchMaxId() {
    	int id = streetDAO.searchMaxId();
        return id;
    }
	
    @Transactional
	public void addStreet(int id, int id_zip, String id_city, int id_street_name, String street_name_label) {
		Street street = new Street();
		street.setId(id);
		street.setId_zip(id_zip);
		street.setId_city(id_city);
		street.setId_street_name(id_street_name);
		street.setStreet_label_name(street_name_label);
		
		streetDAO.addStreet(street);		
    }
    
    @Transactional
    public void subStreet(final Integer IdStreet) {
        final Street lStreet = new Street();
        lStreet.setId(IdStreet);

        streetDAO.subStreet(lStreet);
    }
    
    @Transactional
    public void updateStreet(final List<Street> pListeCountries) {
        for (final Street lStreet : pListeCountries) {
        	streetDAO.updateStreet(lStreet);
        }
    }

	
}
