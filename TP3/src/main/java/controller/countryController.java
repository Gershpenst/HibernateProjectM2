package controller;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Entity.Country;
import Entity.formCountry.CountryForm;
import Entity.formCountry.UpdateCountries;
import Entity.formCountry.UpdateCountryForm;
import Service.ICountryService;

@Controller
@RequestMapping(value="/country")
public class countryController {
	
    private ICountryService serviceCountry;
	
    public ICountryService getCountryService() {
	   return serviceCountry;
    }    
    
    @Autowired
    @Qualifier(value="serviceCountry")
    public void setCountryService(ICountryService serviceCountry) {
	   this.serviceCountry = serviceCountry;
    }
    
	@RequestMapping(method = RequestMethod.GET)
	public String recupererListePays(ModelMap map) {
		List<Country> listePays = serviceCountry.searchCountries();
		map.addAttribute("listCountry", listePays);
		return "pays";
	}
	

	@RequestMapping(value="/printCountry", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<Country> listePays = serviceCountry.searchCountries();
		pModel.addAttribute("listCountry", listePays);
		
		if (pModel.get("creation") == null) {
			pModel.addAttribute("creation", new CountryForm());
		}
		
		return "pays";
	}
	
	
	@RequestMapping(value="/createCountry", method = RequestMethod.POST)
	public String creer(@Valid @ModelAttribute(value="creation") final CountryForm pCreation, final BindingResult pBindingResult, final ModelMap pModel) {
		
		System.out.println("\n\nAs error?: "+pBindingResult.hasErrors());
		System.out.println("pCreation.getCodeIso() empty ? "+ pCreation.getCode_iso().isEmpty());
		System.out.println("Result: "+serviceCountry.searchMaxId());
		
		if(!pCreation.getCode_iso().isEmpty()) {

			if (!pBindingResult.hasErrors()) {
				// System.out.println("Result: "+serviceCountry.searchMaxId());
				serviceCountry.addCountry(serviceCountry.searchMaxId(), pCreation.getId_country(), pCreation.getCode_iso());
			}
		}
		return afficher(pModel);
	}
	
	
	
	
	
    @RequestMapping(value="/subCountry", method = RequestMethod.GET)
    public String subPrint(final ModelMap pModel) {
        final List<Country> listePays = serviceCountry.searchCountries();
        pModel.addAttribute("listCountry", listePays);
        return "subCountry";
    }

    @RequestMapping(value="/subCountryInList", method = RequestMethod.GET)
    public String supprimer(@RequestParam(value="idCountry") final Integer idCountry, final ModelMap pModel) {
    	System.out.println("\n\nidCountry: "+idCountry+"\n");
    	serviceCountry.subCountry(idCountry);;
        return subPrint(pModel);
    }
	
	
    @RequestMapping(value="/updCountry", method = RequestMethod.GET)
    public String updatePrint(final ModelMap pModel) {
        if (pModel.get("modification") == null) {
            final List<Country> lListCountries = serviceCountry.searchCountries();
            
    		List<String> listCountryIso = lListCountries.stream()
    				.map(s -> s.getCode_iso())
    				.collect(Collectors.toList());
    		pModel.addAttribute("listCountryIso", listCountryIso);
            
            final UpdateCountryForm lUpdateCountriesForm = new UpdateCountryForm();
            final List<UpdateCountries> lListe = new LinkedList<UpdateCountries>();
            for (final Country lCountry : lListCountries) {
                final UpdateCountries lUpdateCountry = new UpdateCountries();
                lUpdateCountry.setId(lCountry.getId());
                lUpdateCountry.setId_country(lCountry.getId_country());
                lUpdateCountry.setCode_iso(lCountry.getCode_iso());
                lListe.add(lUpdateCountry);
            }
            lUpdateCountriesForm.setListCountries(lListe);
            pModel.addAttribute("updateCountriesJSP", lUpdateCountriesForm);
        }
        return "updateCountry";
    }

    @RequestMapping(value="/updateListCountries", method = RequestMethod.POST)
    public String updateCountries(@Valid @ModelAttribute(value="updateCountriesJSP") final UpdateCountryForm pModification, 
            final BindingResult pBindingResult, final ModelMap pModel) {

        if (!pBindingResult.hasErrors()) {
            final List<Country> lListeCountries = new LinkedList<Country>();
            for (final UpdateCountries lUpdateCountry : pModification.getListCountries()) {
                final Country lCountry = new Country();
                lCountry.setId(lUpdateCountry.getId());
                lCountry.setId_country(lUpdateCountry.getId_country());
                lCountry.setCode_iso(lUpdateCountry.getCode_iso());
                
                if(lUpdateCountry.getCode_iso().length() != 3 || lUpdateCountry.getId_country() < 1)
                	return updatePrint(pModel);
                
                lListeCountries.add(lCountry);
            }
            
            serviceCountry.updateCountries(lListeCountries);
        }

        return updatePrint(pModel);
    }
    
    
}