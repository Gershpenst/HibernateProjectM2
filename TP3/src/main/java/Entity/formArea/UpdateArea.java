package Entity.formArea;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UpdateArea {
	
	private int id;
	
	private int id_country;
	
	private long language_id;
	
	private int id_area;
	
	@NotEmpty(message="{modification.course.quantite.notempty}")
	private String area_label;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getId_area() {
		return id_area;
	}

	public void setId_area(int id_area) {
		this.id_area = id_area;
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

	public String getArea_label() {
		return area_label;
	}

	public void setArea_label(String area_label) {
		this.area_label = area_label;
	}
	
	
}
