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

import Entity.City;
import Entity.Search.SearchForm;
import Entity.formCity.CityForm;
import Entity.formCity.UpdateCity;
import Entity.formCity.UpdateCityForm;
import Service.ICityService;

@Controller
@RequestMapping(value="/city")
public class CityController {
	private ICityService cityService;
	private int minTable = 0;
	private int maxTable = 100;
	private int step = 100;
	
	
	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getMinTable() {
		return minTable;
	}

	public void setMinTable(int minTable) {
		this.minTable = minTable;
	}

	public int getMaxTable() {
		return maxTable;
	}

	public void setMaxTable(int maxTable) {
		this.maxTable = maxTable;
	}

	
	public ICityService getCityService() {
		return cityService;
	}
	
	// Permet de traiter plus de 1024 requêtes
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.setAutoGrowCollectionLimit(1024);
	}
	
	@Autowired
	@Qualifier("cityService")
	public void setCityService(ICityService cityService) {
		this.cityService = cityService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String allCityView(ModelMap map) {
		List<City> city = cityService.searchCity();
		map.addAttribute("allListCity", city);
		return "city";
	}
	
	
	@RequestMapping(value="/printCity", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<City> listePays = cityService.searchCity();
		pModel.addAttribute("listCity", listePays);
		
		if (pModel.get("creation") == null) {
			pModel.addAttribute("creation", new CityForm());
		}
		
		return "city";
	}
	
	
	@RequestMapping(value="/createCity", method = RequestMethod.POST)
	public String creer(@Valid @ModelAttribute(value="creation") final CityForm pCreation, final BindingResult pBindingResult, final ModelMap pModel) {
		
		System.out.println("\n\nAs error?: "+pBindingResult.hasErrors());

		if(!pCreation.getZip_label().isEmpty()) {
				
			if (!pBindingResult.hasErrors()) { // (int id, int id_city, int id_area, int id_zip, String city_name, String zip_label)
				cityService.addCity(cityService.searchMaxId(), pCreation.getId_city(), pCreation.getId_area(), pCreation.getId_zip(), pCreation.getCity_name(), pCreation.getZip_label());
			}
		}
		return afficher(pModel);
	}
	
	
	
    @RequestMapping(value="/subCity", method = RequestMethod.GET)
    public String subPrint(final ModelMap pModel) {
        final List<City> listCity = cityService.searchCity();
        pModel.addAttribute("listCity", listCity);
        return "subCity";
    }

    @RequestMapping(value="/subCityInList", method = RequestMethod.GET)
    public String supprimer(@RequestParam(value="idCity") final Integer idCity, final ModelMap pModel) {
    	System.out.println("\n\nidCity: "+idCity+"\n");
    	cityService.subCity(idCity);;
        return subPrint(pModel);
    }    
    
    
    @RequestMapping(value="/updCity", method = RequestMethod.GET)
    public String updatePrint(final ModelMap pModel) {
    	
    	System.out.println("updCity");

        if (pModel.get("modification") == null) {
            
        	final List<City> lListCity = cityService.searchCity(getMinTable(), getMaxTable());
        	System.out.println("min: "+getMinTable()+" et max: "+getMaxTable());
            
            final UpdateCityForm lUpdateCityForm = new UpdateCityForm();
            final List<UpdateCity> lListe = new LinkedList<UpdateCity>();
            for (final City lCity : lListCity) {
                final UpdateCity lUpdateCity = new UpdateCity();
                lUpdateCity.setId(lCity.getId());
                lUpdateCity.setId_city(lCity.getId_city());
                lUpdateCity.setId_area(lCity.getId_area());
                lUpdateCity.setId_zip(lCity.getId_zip());
                lUpdateCity.setCity_name(lCity.getCity_name());
                lUpdateCity.setZip_label(lCity.getZip_label());
                
                lListe.add(lUpdateCity);
            }
            lUpdateCityForm.setListCity(lListe);
            pModel.addAttribute("updateCityJSP", lUpdateCityForm);
        }
        return "updCity";
    }

    @RequestMapping(value="/updateListCity", method = RequestMethod.POST)
    public String updateCity(@Valid @ModelAttribute(value="updateCityJSP") final UpdateCityForm pModification, 
        final BindingResult pBindingResult, final ModelMap pModel) {
    	
    	
        if (!pBindingResult.hasErrors()) {
            final List<City> lListeCity = new LinkedList<City>();
            for (final UpdateCity lUpdateCity : pModification.getListCity()) {
            	System.out.println(lUpdateCity.getId()+" "+lUpdateCity.getId_city()+" "+lUpdateCity.getId_area()+" "+lUpdateCity.getId_zip()+" "+lUpdateCity.getCity_name()+" "+lUpdateCity.getZip_label());
                final City lCity = new City();
                lCity.setId(lUpdateCity.getId());
                lCity.setId_city(lUpdateCity.getId_city());
                lCity.setId_area(lUpdateCity.getId_area());
                lCity.setId_zip(lUpdateCity.getId_zip());
                lCity.setCity_name(lUpdateCity.getCity_name());
                lCity.setZip_label(lUpdateCity.getZip_label());
                
                if(lUpdateCity.getId_city().length() < 1 || lUpdateCity.getId_city().length() > 255 || lUpdateCity.getId_area() < 1
                	|| lUpdateCity.getId_zip() < 1 || lUpdateCity.getCity_name().length() < 1 || lUpdateCity.getCity_name().length() > 255 
                	|| lUpdateCity.getZip_label().length() < 1 || lUpdateCity.getZip_label().length() > 255) {
                	return updatePrint(pModel);
                }
                
                lListeCity.add(lCity);
            }
            
            cityService.updateCity(lListeCity);
        }

        return updatePrint(pModel);
    }

    
	@RequestMapping(value="/hello", method = RequestMethod.POST)
	public String details(@Valid @ModelAttribute(value="creation") final SearchForm pCreation, @RequestParam(value="button") final String pB, final BindingResult pBindingResult, final ModelMap pModel) {
		
		if(pCreation != null) {
		
			if (!pBindingResult.hasErrors()) {
				
				if(pB.equals("button1")) {
					System.out.println("Appuyer sur le bouton 1");
					if(getMinTable()-step*10 >= 0) {
						int tmp =  getMinTable()-step*10;
						setMaxTable(tmp + step);
						setMinTable(tmp);
					}else {
						setMaxTable(step);
						setMinTable(0);
					}
				} else if(pB.equals("button2")) {
					if(getMinTable()-step >= 0) {
						setMaxTable(getMinTable());
						setMinTable(getMinTable()-step);
					}
				} else if(pB.equals("button3")) {
					int max = cityService.searchMaxId();
					if(getMaxTable()+step <= max) {
						setMinTable(getMaxTable());
						setMaxTable(getMaxTable()+step);
					}
				} else if(pB.equals("button4")) {
					int max = cityService.searchMaxId();
					if(getMaxTable()+step*10 <= max) {
						int tmp =  getMaxTable()+step*10;
						setMinTable(tmp - step);
						setMaxTable(tmp);
					}else {
						setMinTable(max - step);
						setMaxTable(max);
					}
				}
				
			}
		}
		
		return updatePrint(pModel);
	}
	
	
}
