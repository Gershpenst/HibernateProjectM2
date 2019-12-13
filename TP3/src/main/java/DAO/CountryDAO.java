package DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Entity.Country;


public class CountryDAO implements ICountryDAO {

	
   private SessionFactory sessionFactory;
   

   public void setSessionFactory(SessionFactory sf){
       this.sessionFactory = sf;
   }
   
 
    @Transactional
	public List<Country> searchCountries() {
	   Session session = sessionFactory.getCurrentSession();
       List<Country> countryList = session.createQuery("from Country").list();
       return countryList;
	}
    
    @Transactional
	public int searchMaxId() {
    	Session session = sessionFactory.getCurrentSession();
    	int id = (int) session.createQuery("SELECT MAX(id) FROM Country").list().get(0)+1;
    	 
    	return id;
	}
 
    @Transactional
	public void addCountry(Country country) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(country);
    }
    
    public void subCountry(final Country pCountry) {
    	Session session = sessionFactory.getCurrentSession();

    	Query query = session.createQuery("delete Country where id = :ID");
    	query.setParameter("ID", pCountry.getId());
    }
    
    
    public void updateCountry(final Country pCountry) {
    	Session session = sessionFactory.getCurrentSession();
        
    	Query query = session.createQuery("update Country set CODE_ISO = :CODEISO, ID_COUNTRY = :IDCOUNTRY where id = :ID");
    	query.setParameter("CODEISO", pCountry.getCode_iso());
    	query.setParameter("IDCOUNTRY", pCountry.getId_country());
    	query.setParameter("ID", pCountry.getId());

    }
    
}