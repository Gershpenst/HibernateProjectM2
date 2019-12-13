package Entity.formLanguage;

import java.util.List;

import javax.validation.Valid;

public class UpdateLanguageForm {
    @Valid
    private List<UpdateLanguage> listLanguage;

    public void setListLanguage(final List<UpdateLanguage> plistLanguage) {
    	listLanguage = plistLanguage;
    }

    public List<UpdateLanguage> getListLanguage() {
        return listLanguage;
    }
}
