package DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Entity.Area;

public class AreaDAO implements IAreaDAO{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Area> searchArea(){
		Session session = sessionFactory.getCurrentSession();
		List<Area> area = session.createQuery("FROM Area").list();
		return area;
	}

    @Transactional
	public int searchMaxId() {
    	Session session = sessionFactory.getCurrentSession();
    	int id = (int) session.createQuery("SELECT MAX(id) FROM Area").list().get(0)+1;
    	 
    	return id;
	}
 
    @Transactional
	public void addArea(Area area) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(area);
    }
    
    public void subArea(final Area pArea) {
    	Session session = sessionFactory.getCurrentSession();
    	
    	Query query = session.createQuery("delete Area where id = :ID");
    	query.setParameter("ID", pArea.getId());
    	
    	 
    	int result = query.executeUpdate();
    	
    	System.out.println("result: "+result);
    }
    
    
    public void updateArea(final Area pArea) {
    	Session session = sessionFactory.getCurrentSession();
        
    	Query query = session.createQuery("update Area set ID_COUNTRY = :IDCOUNTRY, LANGUAGE_ID = :LANGUAGEID , ID_AREA = :IDAREA, AREA_LABEL = :AREALABEL where id = :ID");
    	query.setParameter("ID", pArea.getId());
    	query.setParameter("IDCOUNTRY", pArea.getId_country());
    	query.setParameter("LANGUAGEID", pArea.getLanguage_id());
    	query.setParameter("IDAREA", pArea.getId_area());
    	query.setParameter("AREALABEL", pArea.getArea_label());
    	
    }

    	
}
