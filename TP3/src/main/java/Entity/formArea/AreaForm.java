package Entity.formArea;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;



public class AreaForm {

	private int id;
	
	@NotNull(message = "Please enter id country")
	@Min(1)
	private int id_area;
	
	@NotNull(message = "Please enter id country")
	@Min(1)
	private int id_country;
	
	@NotNull(message = "Please enter id language")
	@Min(1)
	private long language_id;
	
	@NotEmpty(message="champs vide")
	@Length(min=1, max=255, message="Longueur doit être entre 1 et 255")
	private String area_label;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_country() {
		return id_country;
	}

	public void setId_country(int id_country) {
		this.id_country = id_country;
	}

	public long getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(long language_id) {
		this.language_id = language_id;
	}

	
	public int getId_area() {
		return id_area;
	}

	public void setId_area(int id_area) {
		this.id_area = id_area;
	}

	public String getArea_label() {
		return area_label;
	}

	public void setArea_label(String area_label) {
		this.area_label = area_label;
	}
	
	
}

/*
 *  dump
 * */
