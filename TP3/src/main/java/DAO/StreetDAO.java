package DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Entity.Street;

public class StreetDAO implements IStreetDAO {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Street> searchStreet(){
		Session session = sessionFactory.getCurrentSession();
		List<Street> street = session.createQuery("FROM Street").list();
		return street;
	}
	
    @Transactional
	public int searchMaxId() {
    	Session session = sessionFactory.getCurrentSession();
    	int id = (int) session.createQuery("SELECT MAX(id) FROM Street").list().get(0)+1;
    	 
    	return id;
	}

 
    @Transactional
	public void addStreet(Street street) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(street);
    }
    
    public void subStreet(final Street pStreet) {
    	Session session = sessionFactory.getCurrentSession();
    	
    	Query query = session.createQuery("delete Street where id = :ID");
    	query.setParameter("ID", pStreet.getId());
    	
    }
    
    
    public void updateStreet(final Street pStreet) {
    	Session session = sessionFactory.getCurrentSession();
        
    	Query query = session.createQuery("update Street set ID_STREET_NAME = :IDSTREETNAME, ID_CITY = :IDCITY, ID_ZIP = :IDZIP, STREET_NAME_LABEL = :STREETNAMELABEL where id = :ID");
    	query.setParameter("ID", pStreet.getId());
    	query.setParameter("IDZIP", pStreet.getId_zip());
    	query.setParameter("IDSTREETNAME", pStreet.getId_street_name());
    	query.setParameter("IDCITY", pStreet.getId_city());
    	query.setParameter("STREETNAMELABEL", pStreet.getStreet_label_name());

    }

    	
}
