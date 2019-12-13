package controller;

import java.util.List;
import java.util.stream.Collectors;

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

import Entity.Area;
import Entity.City;
import Entity.Country;
import Entity.Street;
import Entity.Search.SearchForm;
import Service.ISearchService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	private ISearchService searchService;
	
	private String countryHtml, areaHtml, cityHtml, streetHtml, languageHtml;
	private Boolean areaBool, cityBool, streetBool;
	
	private Boolean submit;
	private List<String> listStreetLabel;
	private List<String> listAreaLabel;
	private List<String> listCountryCodeIso;
	private List<String> listCityName;
	
	private String outputHtml;
	
	List<Street> listStreetCpy;
	
	public SearchController() {
		countryHtml="";
		areaHtml="";
		cityHtml="";
		streetHtml="";
		languageHtml="";
		
		areaBool = false;
		cityBool = false;
		streetBool = false;
		
		submit = true;
	}

	public ISearchService getSearchService() {
		return searchService;
	}

	
	// Permet de traiter plus de 1024 requêtes
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.setAutoGrowCollectionLimit(1024);
	}
	
	@Autowired
	@Qualifier("searchService")
	public void setSearchService(ISearchService searchService) {
		this.searchService = searchService;
	}
	
	
	@RequestMapping(value="/printSearch", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		
		if(submit == true) {

			// Country
			List<Country> listCountry = searchService.searchCountry();
			listCountryCodeIso = listCountry.stream().map(s -> s.getCode_iso()).collect(Collectors.toList());

			submit = false;
		}

		pModel.addAttribute("listStreetLabel", listStreetLabel);
		pModel.addAttribute("listAreaLabel", listAreaLabel);
		pModel.addAttribute("listCountryCodeIso", listCountryCodeIso);
		pModel.addAttribute("listCityName", listCityName);

		
		if (pModel.get("creation") == null) {
			pModel.addAttribute("creation", new SearchForm());
		}
		
		return "search";
	}
	
	
	
	@RequestMapping(value="/createSearch", method = RequestMethod.POST)
	public String details(@Valid @ModelAttribute(value="creation") final SearchForm pCreation, final BindingResult pBindingResult, final ModelMap pModel) {

		if(pCreation != null) {
	
			if (!pBindingResult.hasErrors()) {
				System.out.println(pCreation.toString());
				
				
				if(!pCreation.getArea_label().equals("") && !pCreation.getCity_name().equals("") && 
				   !pCreation.getCountry_code_iso().equals("") && !pCreation.getStreet_label_name().equals("")) {
					submit = true;
				}
				
				
				if(!pCreation.getCountry_code_iso().equals(countryHtml)) {

					// Area
					List<Area> listArea = searchService.searchArea(pCreation.getCountry_code_iso());
					if(!listArea.isEmpty()) {
						areaBool = true;
						cityBool = false;
						streetBool = false;
						listAreaLabel = listArea.stream().map(s -> s.getArea_label()).collect(Collectors.toList());
					}else {
						areaBool = false;		
						cityBool = false;
						streetBool = false;
					}
					
					
					countryHtml = pCreation.getCountry_code_iso();
					areaHtml="";
					pCreation.setArea_label("");
					cityHtml="";
					pCreation.setCity_name("");
					streetHtml="";
					pCreation.setStreet_label_name("");
					languageHtml="";
				}
				
				
				if(!pCreation.getArea_label().equals(areaHtml)) {
					
					List<City> listCity = searchService.searchCity(pCreation.getArea_label());
					if(!listCity.isEmpty()) {
						cityBool = true;
						streetBool = false;
						listCityName = listCity.stream().map(s -> s.getCity_name()).collect(Collectors.toList());
						languageHtml = searchService.searchLanguage(pCreation.getArea_label());
					}else {		
						cityBool = false;
						streetBool = false;
					}
					
					
					areaHtml = pCreation.getArea_label();
					cityHtml="";
					pCreation.setCity_name("");
					streetHtml="";
					pCreation.setStreet_label_name("");

				}
				
				if(!pCreation.getCity_name().equals(cityHtml)) {
					
					List<Street> listStreet = searchService.searchStreet(pCreation.getCity_name(), pCreation.getArea_label());
					
					listStreetCpy = listStreet.stream().map(s -> s).collect(Collectors.toList());
					
					if(!listStreet.isEmpty()) {
						streetBool = true;
						listStreetLabel = listStreet.stream().map(s -> s.getStreet_label_name()).collect(Collectors.toList());
					}else {		
						streetBool = false;
					}
					 
					cityHtml = pCreation.getCity_name();
					streetHtml="";
					pCreation.setStreet_label_name("");

				}
				
				
				if(!pCreation.getStreet_label_name().equals(streetHtml)) {
					
					streetHtml = pCreation.getStreet_label_name();

				}
				
				
				outputHtml = "Output:\nPays: "+pCreation.getCountry_code_iso()+"<br>Région: "+pCreation.getArea_label()+"<br>Ville: "+pCreation.getCity_name()+"<br>Rue: "+pCreation.getCity_name()+"<br>";
				
				pModel.addAttribute("areaBool", areaBool);
				pModel.addAttribute("cityBool", cityBool);
				pModel.addAttribute("streetBool", streetBool);
				pModel.addAttribute("outputHtml", outputHtml);
				
				
				pModel.addAttribute("pays", countryHtml);
				pModel.addAttribute("region", areaHtml);
				pModel.addAttribute("language", languageHtml);
				pModel.addAttribute("ville", cityHtml);
				pModel.addAttribute("rue", streetHtml); 
				
			}
		}
		return afficher(pModel);
	}
	
}