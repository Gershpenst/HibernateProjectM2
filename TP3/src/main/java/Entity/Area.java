package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="area")
public class Area {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="ID_COUNTRY")
	private int id_country;
	
	@Column(name="LANGUAGE_ID")
	private long language_id;
	
	@Column(name="ID_AREA")
	private int id_area;
	
	@Column(name="AREA_LABEL")
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
	

	public int getId_area() {
		return id_area;
	}

	public void setId_area(int id_area) {
		this.id_area = id_area;
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
