package Entity.formCountry;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;



public class CountryForm {

	@NotNull(message = "Please enter id")
	@Min(1)
	private Integer id;
	
	@NotNull(message = "Please enter id country")
	@Min(1)
	private int id_country;
	
	@NotEmpty(message="champs vide")
	@Length(min=3, max=3, message="Longueur doit être de 3")
	private String code_iso;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

/*
 *  dump
 * */
