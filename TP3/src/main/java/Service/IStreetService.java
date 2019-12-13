package Service;

import java.util.List;

import Entity.Street;

public interface IStreetService {
	List<Street> searchStreet();
	int searchMaxId();
    void addStreet(int id, int id_zip, String id_city, int id_street_name, String street_name_label);
    void subStreet(final Integer streetId);
    void updateStreet(final List<Street> pListStreet);
}
