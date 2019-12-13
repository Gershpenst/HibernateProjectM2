package DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Entity.City;

public class CityDAO implements ICityDAO {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<City> searchCity(){
		Session session = sessionFactory.getCurrentSession();
		List<City> city = session.createQuery("FROM City").list();
		return city;
	}
	
	public List<City> searchCity(int min, int max){
		Session session = sessionFactory.getCurrentSession();
		List<City> city = session.createQuery("FROM City WHERE id >= "+min+" AND id <= "+max).list();
		return city;
	}

    @Transactional
	public int searchMaxId() {
    	Session session = sessionFactory.getCurrentSession();
    	int id = (int) session.createQuery("SELECT MAX(id) FROM City").list().get(0)+1;
    	 
    	return id;
	}
 
    @Transactional
	public void addCity(City city) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(city);
    }
    
    public void subCity(final City pCity) {
    	Session session = sessionFactory.getCurrentSession();
    	
    	Query query = session.createQuery("delete City where id = :ID");
    	query.setParameter("ID", pCity.getId());
    	
    }
    
    
    public void updateCity(final City pCity) {
    	Session session = sessionFactory.getCurrentSession();
    	
    	System.out.println("Je suis dans l'update City");
    	
    	Query query = session.createQuery("update City set ID_CITY = :IDCITY, ID_AREA = :IDAREA , ID_ZIP = :IDZIP, CITY_NAME = :CITYNAME, ZIP_LABEL = :ZIPLABEL where id = :ID");
    	query.setParameter("ID", pCity.getId());
    	query.setParameter("IDCITY", pCity.getId_city());
    	query.setParameter("IDAREA", pCity.getId_area());
    	query.setParameter("IDZIP", pCity.getId_zip());
    	query.setParameter("CITYNAME", pCity.getCity_name());
    	query.setParameter("ZIPLABEL", pCity.getZip_label());
    	
    }


}
