package Entity;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {

    @Id
    @Column(name="id", nullable = false)
    private int id;
    
    @Column(name="ID_COUNTRY")
    private int id_country;
    
    @Column(name="CODE_ISO")
    private String code_iso;

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

	public String getCode_iso() {
		return code_iso;
	}

	public void setCode_iso(String code_iso) {
		this.code_iso = code_iso;
	}

    
}


