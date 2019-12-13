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

import Entity.Street;
import Entity.formStreet.StreetForm;
import Entity.formStreet.UpdateStreet;
import Entity.formStreet.UpdateStreetForm;
import Service.IStreetService;

@Controller
@RequestMapping(value="/street")
public class StreetController {
	private IStreetService streetService;

	public IStreetService getStreetService() {
		return streetService;
	}
	
	// Permet de traiter plus de 1024 requêtes
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.setAutoGrowCollectionLimit(1024);
	}
	
	@Autowired
	@Qualifier("streetService")
	public void setStreetService(IStreetService streetService) {
		this.streetService = streetService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String allStreetView(ModelMap map) {
		List<Street> street = streetService.searchStreet();
		map.addAttribute("allListStreet", street);
		return "street";
	}
	
	
	@RequestMapping(value="/printStreet", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<Street> listePays = streetService.searchStreet();
		pModel.addAttribute("listStreet", listePays);
		
		if (pModel.get("creation") == null) {
			pModel.addAttribute("creation", new StreetForm());
		}
		
		return "street";
	}
	
	
	@RequestMapping(value="/createStreet", method = RequestMethod.POST)
	public String creer(@Valid @ModelAttribute(value="creation") final StreetForm pCreation, final BindingResult pBindingResult, final ModelMap pModel) {
		
		if(!pCreation.getStreet_label_name().isEmpty()) {

			if (!pBindingResult.hasErrors()) {
				streetService.addStreet(streetService.searchMaxId(), pCreation.getId_zip(), pCreation.getId_city(), pCreation.getId_street_name(), pCreation.getStreet_label_name());
			}
		}
		return afficher(pModel);
	}
	
	
	
    @RequestMapping(value="/subStreet", method = RequestMethod.GET)
    public String subPrint(final ModelMap pModel) {
        final List<Street> listStreet = streetService.searchStreet();
        pModel.addAttribute("listStreet", listStreet);
        return "subStreet";
    }

    @RequestMapping(value="/subStreetInList", method = RequestMethod.GET)
    public String supprimer(@RequestParam(value="idStreet") final Integer idStreet, final ModelMap pModel) {
    	System.out.println("\n\nidStreet: "+idStreet+"\n");
    	streetService.subStreet(idStreet);;
        return subPrint(pModel);
    }    
    
    
    @RequestMapping(value="/updStreet", method = RequestMethod.GET)
    public String updatePrint(final ModelMap pModel) {
        if (pModel.get("modification") == null) {
            final List<Street> lListStreet = streetService.searchStreet();
            final UpdateStreetForm lUpdateStreetForm = new UpdateStreetForm();
            final List<UpdateStreet> lListe = new LinkedList<UpdateStreet>();
            for (final Street lStreet : lListStreet) {
                final UpdateStreet lUpdateStreet = new UpdateStreet();
                lUpdateStreet.setId(lStreet.getId());
                lUpdateStreet.setId_zip(lStreet.getId_zip());
                lUpdateStreet.setId_city(lStreet.getId_city());
                lUpdateStreet.setId_street_name(lStreet.getId_street_name());
                lUpdateStreet.setStreet_label_name(lStreet.getStreet_label_name());
                
                lListe.add(lUpdateStreet);
            }
            lUpdateStreetForm.setListStreet(lListe);
            pModel.addAttribute("updateStreetJSP", lUpdateStreetForm);
        }
        return "updStreet";
    }

    @RequestMapping(value="/updateListStreet", method = RequestMethod.POST)
    public String updateStreet(@Valid @ModelAttribute(value="updateStreetJSP") final UpdateStreetForm pModification, 
            final BindingResult pBindingResult, final ModelMap pModel) {

        if (!pBindingResult.hasErrors()) {
            final List<Street> lListeStreet = new LinkedList<Street>();
            for (final UpdateStreet lUpdateStreet : pModification.getListStreet()) {
                final Street lStreet = new Street();
                lStreet.setId(lUpdateStreet.getId());
                lStreet.setId_zip(lUpdateStreet.getId_zip());
                lStreet.setId_city(lUpdateStreet.getId_city());
                lStreet.setId_street_name(lUpdateStreet.getId_street_name());
                lStreet.setStreet_label_name(lUpdateStreet.getStreet_label_name());
                
                if(lUpdateStreet.getId_zip() < 1 || lUpdateStreet.getId_city().length() < 1 || lUpdateStreet.getId_city().length() > 255 || lUpdateStreet.getId_street_name() < 1 || (lUpdateStreet.getStreet_label_name().length() < 5 || lUpdateStreet.getStreet_label_name().length() > 255)) {
                	System.out.println("test: "+lUpdateStreet.getId_city()+" et "+lUpdateStreet.getId_city().length());
                	return updatePrint(pModel);
                }
                
                lListeStreet.add(lStreet);
            }
            
            streetService.updateStreet(lListeStreet);
        }

        return updatePrint(pModel);
    }

	
}

