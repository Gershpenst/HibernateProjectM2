package Entity.formCity;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UpdateCity {

	private int id;	

	//@NotEmpty(message="champs vide")
	//@Length(min=1, max=255, message="Longueur doit être entre 1 et 255")
	private String id_city;

	//@NotNull(message = "Please enter id area")
	//@Min(1)
	private int id_area;
	
	//@NotNull(message = "Please enter id zip")
	//@Min(1)
	private int id_zip;
	
	//@NotEmpty(message="champs vide")
	//@Length(min=1, max=255, message="Longueur doit être entre 1 et 255")
	private String city_name;
	
	//@NotEmpty(message="champs vide")
	//@Length(min=1, max=255, message="Longueur doit être entre 1 et 255")
	private String zip_label;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_city() {
		return id_city;
	}

	public void setId_city(String id_city) {
		this.id_city = id_city;
	}

	public int getId_area() {
		return id_area;
	}

	public void setId_area(int id_area) {
		this.id_area = id_area;
	}

	public int getId_zip() {
		return id_zip;
	}

	public void setId_zip(int id_zip) {
		this.id_zip = id_zip;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getZip_label() {
		return zip_label;
	}

	public void setZip_label(String zip_label) {
		this.zip_label = zip_label;
	}
	
	
}
