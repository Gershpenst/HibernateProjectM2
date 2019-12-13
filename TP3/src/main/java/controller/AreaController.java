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

import Entity.Area;
import Entity.formArea.AreaForm;
import Entity.formArea.UpdateArea;
import Entity.formArea.UpdateAreaForm;
import Service.IAreaService;

@Controller
@RequestMapping(value="/area")
public class AreaController {
	private IAreaService areaService;

	public IAreaService getAreaService() {
		return areaService;
	}
	
	// Permet de traiter plus de 1024 requêtes
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.setAutoGrowCollectionLimit(1024);
	}
	
	@Autowired
	@Qualifier("areaService")
	public void setAreaService(IAreaService areaService) {
		this.areaService = areaService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String allAreaView(ModelMap map) {
		List<Area> area = areaService.searchArea();
		map.addAttribute("allListArea", area);
		return "area";
	}
	
	
	@RequestMapping(value="/printArea", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<Area> listePays = areaService.searchArea();
		pModel.addAttribute("listArea", listePays);
		
		System.out.println("listArea creation: "+pModel.get("creation"));
		
		if (pModel.get("creation") == null) {
			pModel.addAttribute("creation", new AreaForm());
		}
		
		return "area";
	}
	
	
	@RequestMapping(value="/createArea", method = RequestMethod.POST)
	public String creer(@Valid @ModelAttribute(value="creation") final AreaForm pCreation, final BindingResult pBindingResult, final ModelMap pModel) {

		if(!pCreation.getArea_label().isEmpty()) {
			
			System.out.println("test: "+pCreation.getId() +" "+ pCreation.getId_country() +" "+ pCreation.getLanguage_id() +" "+ pCreation.getArea_label());
	
			if (!pBindingResult.hasErrors()) {
				areaService.addArea(areaService.searchMaxId(), pCreation.getId_area(), pCreation.getId_country(), pCreation.getLanguage_id(), pCreation.getArea_label());
			}
		}
		return afficher(pModel);
	}
	
	
	
    @RequestMapping(value="/subArea", method = RequestMethod.GET)
    public String subPrint(final ModelMap pModel) {
        final List<Area> listArea = areaService.searchArea();
        pModel.addAttribute("listArea", listArea);
        return "subArea";
    }

    @RequestMapping(value="/subAreaInList", method = RequestMethod.GET)
    public String supprimer(@RequestParam(value="idArea") final Integer idArea, final ModelMap pModel) {
    	System.out.println("\n\nidArea: "+idArea+"\n");
    	areaService.subArea(idArea);;
        return subPrint(pModel);
    }    
    
    
    @RequestMapping(value="/updArea", method = RequestMethod.GET)
    public String updatePrint(final ModelMap pModel) {
        if (pModel.get("modification") == null) {
            final List<Area> lListArea = areaService.searchArea();
            final UpdateAreaForm lUpdateAreaForm = new UpdateAreaForm();
            final List<UpdateArea> lListe = new LinkedList<UpdateArea>();
            for (final Area lArea : lListArea) {
                final UpdateArea lUpdateArea = new UpdateArea();
                lUpdateArea.setId(lArea.getId());
                lUpdateArea.setId_country(lArea.getId_country());
                lUpdateArea.setArea_label(lArea.getArea_label());
                lUpdateArea.setId_area(lArea.getId_area());
                lUpdateArea.setLanguage_id(lArea.getLanguage_id());
                
                System.out.println("id_update: "+lUpdateArea.getId());
                
                lListe.add(lUpdateArea);
            }
            lUpdateAreaForm.setListArea(lListe);
            pModel.addAttribute("updateAreaJSP", lUpdateAreaForm);
        }
        return "updArea";
    }

    @RequestMapping(value="/updateListArea", method = RequestMethod.POST)
    public String updateArea(@Valid @ModelAttribute(value="updateAreaJSP") final UpdateAreaForm pModification, 
            final BindingResult pBindingResult, final ModelMap pModel) {

        if (!pBindingResult.hasErrors()) {
            final List<Area> lListeArea = new LinkedList<Area>();
            for (final UpdateArea lUpdateArea : pModification.getListArea()) {
                final Area lArea = new Area();
                lArea.setId(lUpdateArea.getId());
                lArea.setId_country(lUpdateArea.getId_country());
                lArea.setArea_label(lUpdateArea.getArea_label());
                lArea.setId_area(lUpdateArea.getId_area());
                lArea.setLanguage_id(lUpdateArea.getLanguage_id());
                
                if(lUpdateArea.getId_country() < 1 || lUpdateArea.getArea_label().length() < 1 || lUpdateArea.getArea_label().length() > 255 || lUpdateArea.getId_area() < 1 || lUpdateArea.getLanguage_id() < 1)
                	return updatePrint(pModel);
                
                lListeArea.add(lArea);
            }
            
            areaService.updateArea(lListeArea);
        }

        return updatePrint(pModel);
    }


}
