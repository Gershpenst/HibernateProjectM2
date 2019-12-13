package DAO;

import java.util.List;

import Entity.Language;

public interface ILanguageDAO {
	List<Language> searchLanguage();
	int searchMaxId();
    void addLanguage(Language language);
    void subLanguage(final Language language);
    void updateLanguage(final Language language);
}

