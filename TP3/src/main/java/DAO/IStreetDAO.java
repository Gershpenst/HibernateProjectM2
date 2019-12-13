package DAO;


import java.util.List;

import Entity.Street;

public interface IStreetDAO {
	List<Street> searchStreet();
	int searchMaxId();
    void addStreet(Street street);
    void subStreet(final Street street);
    void updateStreet(final Street street);
}
