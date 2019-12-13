package Entity.Search;

public class SearchForm {
	private String street_label_name;
	private String area_label;
	private String country_code_iso;
	private String city_name;
	
	public String toString() {
		return getArea_label()+" "+getStreet_label_name()+" "+getCountry_code_iso()+" "+getCity_name();
	}
	
	public String getArea_label() {
		return area_label;
	}
	public void setArea_label(String area_label) {
		this.area_label = area_label;
	}
	public String getStreet_label_name() {
		return street_label_name;
	}
	public void setStreet_label_name(String street_label_name) {
		this.street_label_name = street_label_name;
	}
	public String getCountry_code_iso() {
		return country_code_iso;
	}
	public void setCountry_code_iso(String country_code_iso) {
		this.country_code_iso = country_code_iso;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	
	
}
