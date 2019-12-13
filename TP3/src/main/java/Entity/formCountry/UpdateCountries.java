package Entity.formCountry;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class UpdateCountries {
	private int id;
	
	private int id_country;
	
    @NotEmpty(message="{modification.course.quantite.notempty}")
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
