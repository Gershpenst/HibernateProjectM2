package DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Entity.Language;

public class LanguageDAO implements ILanguageDAO{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Language> searchLanguage(){
		Session session = sessionFactory.getCurrentSession();
		List<Language> language = session.createQuery("FROM Language").list();
		return language;
	}

    @Transactional
	public int searchMaxId() {
    	Session session = sessionFactory.getCurrentSession();
    	int id = (int) session.createQuery("SELECT MAX(id) FROM Language").list().get(0)+1;

    	return id;
	}
	
    @Transactional
	public void addLanguage(Language language) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(language);
    }
    
    public void subLanguage(final Language pLanguage) {
    	Session session = sessionFactory.getCurrentSession();
    	
    	Query query = session.createQuery("delete Language where id = :ID");
    	query.setParameter("ID", pLanguage.getId());
    	
    }
    
    
    public void updateLanguage(final Language pLanguage) {
    	Session session = sessionFactory.getCurrentSession();
        
    	Query query = session.createQuery("update Language set LANGUAGE_CODE = :LANGUAGECODE , LANGUAGE_NAME = :LANGUAGENAME, LANGUAGE_ID = :LANGUAGEID where id = :ID");
    	query.setParameter("ID", pLanguage.getId());
    	query.setParameter("LANGUAGEID", pLanguage.getLanguage_id());
    	query.setParameter("LANGUAGECODE", pLanguage.getLanguage_code());
    	query.setParameter("LANGUAGENAME", pLanguage.getLanguage_name());

    }


}
