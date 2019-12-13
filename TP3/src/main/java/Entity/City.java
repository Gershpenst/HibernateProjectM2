package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="ID_CITY")
	private String id_city;
	
	@Column(name="ID_AREA")
	private int id_area;
	
	@Column(name="ID_ZIP")
	private int id_zip;
	
	@Column(name="CITY_NAME")
	private String city_name;
	
	@Column(name="ZIP_LABEL")
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
