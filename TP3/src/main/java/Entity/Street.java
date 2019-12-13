package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="street")
public class Street {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="ID_STREET_NAME")
	private int id_street_name;
	
	@Column(name="ID_ZIP")
	private int id_zip;
	
	@Column(name="ID_CITY")
	private String id_city;
	
	@Column(name="STREET_NAME_LABEL")
	private String street_label_name;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_zip() {
		return id_zip;
	}

	public void setId_zip(int id_zip) {
		this.id_zip = id_zip;
	}

	public int getId_street_name() {
		return id_street_name;
	}
	
	public void setId_street_name(int id_street_name) {
		this.id_street_name = id_street_name;
	}
	
	public String getId_city() {
		return id_city;
	}
	
	public void setId_city(String id_city) {
		this.id_city = id_city;
	}
	
	public String getStreet_label_name() {
		return street_label_name;
	}
	
	public void setStreet_label_name(String street_label_name) {
		this.street_label_name = street_label_name;
	}
	
	
}
