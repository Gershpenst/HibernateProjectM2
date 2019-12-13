package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Entity.Area;
import Entity.City;
import Entity.Country;
import Entity.Language;
import Entity.Street;

public class SearchDAO implements ISearchDAO {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public String searchLanguage(String id_area) {
		Session session = sessionFactory.getCurrentSession();
		List<Area> listArea = session.createQuery("FROM Area WHERE AREA_LABEL = '"+id_area+"'").list();
		
		if(!listArea.isEmpty()) {
			List<Language> listLanguage = session.createQuery("FROM Language WHERE LANGUAGE_ID = "+listArea.get(0).getLanguage_id()).list();
			if(!listLanguage.isEmpty()) {
				return listLanguage.get(0).getLanguage_name();
			}
		}
		return "";
	}
	
	public List<Street> searchStreet(){
		Session session = sessionFactory.getCurrentSession();
		List<Street> street = session.createQuery("FROM Street").list();
		return street;
	}
	

	public List<Street> searchStreet(String id_city, String area_label){
		Session session = sessionFactory.getCurrentSession();
		List<Street> listStreet = new ArrayList<>();
		
		
		List<Area> listArea = session.createQuery("FROM Area WHERE AREA_LABEL = '"+area_label+"'").list();
		
		if(!listArea.isEmpty()) {
			List<City> listCity = session.createQuery("FROM City WHERE CITY_NAME = '"+id_city+"' AND ID_AREA = "+listArea.get(0).getId_area()).list();
	
			if(!listCity.isEmpty()) {
				listStreet = session.createQuery("FROM Street WHERE ID_CITY='"+listCity.get(0).getId_city()+"' AND ID_ZIP="+listCity.get(0).getId_zip()+" ORDER BY STREET_NAME_LABEL").list();
			} 
		}
		
		return listStreet;
	}

	public List<Area> searchArea(){
		Session session = sessionFactory.getCurrentSession();
		List<Area> area = session.createQuery("FROM Area").list();
		return area;
	}
	
	public List<Area> searchArea(String code_iso){
		Session session = sessionFactory.getCurrentSession();
		List<Area> listArea = new ArrayList<>();

		List<Country> listCountry = session.createQuery("FROM Country WHERE CODE_ISO = '"+code_iso+"'").list();

		if(!listCountry.isEmpty()) {
			listArea = session.createQuery("FROM Area WHERE ID_COUNTRY="+listCountry.get(0).getId_country()+" ORDER BY AREA_LABEL").list();
		} 
    	
    	return listArea;
	}
	
	public List<Country> searchCountry(){
		Session session = sessionFactory.getCurrentSession();
		List<Country> country = session.createQuery("FROM Country ORDER BY CODE_ISO").list();
		return country;
	}
	
	public List<City> searchCity(){
		Session session = sessionFactory.getCurrentSession();
		List<City> city = session.createQuery("FROM City").list();
		return city;
	}
	
	public List<City> searchCity(String id_area){
		Session session = sessionFactory.getCurrentSession();
		List<City> listCity = new ArrayList<>();

		List<Area> listArea = session.createQuery("FROM Area WHERE AREA_LABEL = '"+id_area+"'").list();

		if(!listArea.isEmpty()) {
			listCity = session.createQuery("FROM City WHERE ID_AREA="+listArea.get(0).getId_area()+" ORDER BY CITY_NAME").list();
		} 
		
		return listCity;
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
    
    	
}
