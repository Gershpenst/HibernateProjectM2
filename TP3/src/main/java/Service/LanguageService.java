package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.ILanguageDAO;
import Entity.Language;

@Service
public class LanguageService implements ILanguageService{
	@Autowired
	private ILanguageDAO languageDAO;
	
	public void setLanguageDAO(ILanguageDAO languageDAO) {
		this.languageDAO = languageDAO;
	}
	
	@Transactional(readOnly=true)
	public List<Language> searchLanguage(){
		List<Language> listLanguage = languageDAO.searchLanguage();
		return listLanguage;
	}
	
    @Transactional(readOnly=true)
    public int searchMaxId() {
    	int id = languageDAO.searchMaxId();
        return id;
    }
	
    @Transactional
	public void addLanguage(int id, long language_id, String language_code, String language_name) {
		Language language = new Language();
		language.setId(id);
		language.setLanguage_id(language_id);
		language.setLanguage_code(language_code);
		language.setLanguage_name(language_name);
		
		languageDAO.addLanguage(language);		
    }
    
    @Transactional
    public void subLanguage(final int IdLanguage) {
        final Language lLanguage = new Language();
        lLanguage.setId(IdLanguage);

        languageDAO.subLanguage(lLanguage);
    }
    
    @Transactional
    public void updateLanguage(final List<Language> pListeLanguage) {
        for (final Language lLanguage : pListeLanguage) {
        	languageDAO.updateLanguage(lLanguage);
        }
    }

}
