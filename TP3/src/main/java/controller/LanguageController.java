package controller;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Entity.Language;
import Entity.formLanguage.LanguageForm;
import Entity.formLanguage.UpdateLanguage;
import Entity.formLanguage.UpdateLanguageForm;
import Service.ILanguageService;

@Controller
@RequestMapping(value="/language")
public class LanguageController {
	private ILanguageService languageService;

	public ILanguageService getLanguageService() {
		return languageService;
	}
	
	// Permet de traiter plus de 1024 requêtes
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.setAutoGrowCollectionLimit(1024);
	}
	
	@Autowired
	@Qualifier("languageService")
	public void setLanguageService(ILanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String allLanguageView(ModelMap map) {
		List<Language> language = languageService.searchLanguage();
		map.addAttribute("allListLanguage", language);
		return "language";
	}
	
	
	@RequestMapping(value="/printLanguage", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<Language> listePays = languageService.searchLanguage();
		pModel.addAttribute("listLanguage", listePays);
		
		if (pModel.get("creation") == null) {
			pModel.addAttribute("creation", new LanguageForm());
		}
		
		return "language";
	}
	
	
	@RequestMapping(value="/createLanguage", method = RequestMethod.POST)
	public String creer(@Valid @ModelAttribute(value="creation") final LanguageForm pCreation, final BindingResult pBindingResult, final ModelMap pModel) {

		if(!pCreation.getLanguage_name().isEmpty()) {
			
			if (!pBindingResult.hasErrors()) {
				languageService.addLanguage(languageService.searchMaxId(), pCreation.getLanguage_id(), pCreation.getLanguage_code(), pCreation.getLanguage_name());
			}
		}
		return afficher(pModel);
	}
		
	
	
    @RequestMapping(value="/subLanguage", method = RequestMethod.GET)
    public String subPrint(final ModelMap pModel) {
        final List<Language> listLanguage = languageService.searchLanguage();
        pModel.addAttribute("listLanguage", listLanguage);
        return "subLanguage";
    }

    @RequestMapping(value="/subLanguageInList", method = RequestMethod.GET)
    public String supprimer(@RequestParam(value="id") final int id, final ModelMap pModel) {
    	System.out.println("\n\nidLanguage: "+id+"\n");
    	languageService.subLanguage(id);
        return subPrint(pModel);
    }    
    
    
    @RequestMapping(value="/updLanguage", method = RequestMethod.GET)
    public String updatePrint(final ModelMap pModel) {
        if (pModel.get("modification") == null) {
            final List<Language> lListLanguage = languageService.searchLanguage();
            final UpdateLanguageForm lUpdateLanguageForm = new UpdateLanguageForm();
            final List<UpdateLanguage> lListe = new LinkedList<UpdateLanguage>();
            for (final Language lLanguage : lListLanguage) {
                final UpdateLanguage lUpdateLanguage = new UpdateLanguage();
                lUpdateLanguage.setId(lLanguage.getId());
                lUpdateLanguage.setLanguage_id(lLanguage.getLanguage_id());
                lUpdateLanguage.setLanguage_code(lLanguage.getLanguage_code());
                lUpdateLanguage.setLanguage_name(lLanguage.getLanguage_name());
                
                lListe.add(lUpdateLanguage);
            }
            lUpdateLanguageForm.setListLanguage(lListe);
            pModel.addAttribute("updateLanguageJSP", lUpdateLanguageForm);
        }
        return "updLanguage";
    }

    @RequestMapping(value="/updateListLanguage", method = RequestMethod.POST)
    public String updateLanguage(@Valid @ModelAttribute(value="updateLanguageJSP") final UpdateLanguageForm pModification, 
            final BindingResult pBindingResult, final ModelMap pModel) {

        if (!pBindingResult.hasErrors()) {
            final List<Language> lListeLanguage = new LinkedList<Language>();
            for (final UpdateLanguage lUpdateLanguage : pModification.getListLanguage()) {
                final Language lLanguage = new Language();
                lLanguage.setId(lUpdateLanguage.getId());
                lLanguage.setLanguage_id(lUpdateLanguage.getLanguage_id());
                lLanguage.setLanguage_code(lUpdateLanguage.getLanguage_code());
                lLanguage.setLanguage_name(lUpdateLanguage.getLanguage_name());
                
                if(lUpdateLanguage.getLanguage_id() < 1 || lUpdateLanguage.getLanguage_code().length() != 3 || lUpdateLanguage.getLanguage_name().length() < 1 || lUpdateLanguage.getLanguage_name().length() > 255)
                	return updatePrint(pModel);
                
                lListeLanguage.add(lLanguage);
            }
            
            languageService.updateLanguage(lListeLanguage);
        }

        return updatePrint(pModel);
    }


}
