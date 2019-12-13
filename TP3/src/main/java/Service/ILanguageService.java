package Service;

import java.util.List;

import Entity.Language;

public interface ILanguageService {
    List<Language> searchLanguage();
    int searchMaxId(); 
    void addLanguage(int id, long language_id, String language_code, String language_name);
    void subLanguage(final int LanguageId);
    void updateLanguage(final List<Language> pListLanguage);
}
