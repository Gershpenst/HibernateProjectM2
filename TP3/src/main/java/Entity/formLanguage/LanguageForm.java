package Entity.formLanguage;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;



public class LanguageForm {
	
	private int id;

	@NotNull(message = "Please enter id")
	@Min(1)
	private long language_id;
	
	@NotEmpty(message="champs vide")
	@Length(min=3, max=3, message="Longueur doit être de 3")
	private String language_code;
	
	@NotEmpty(message="champs vide")
	@Length(min=1, max=255, message="Longueur doit être entre 5 et 255")
	private String language_name;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(long language_id) {
		this.language_id = language_id;
	}

	public String getLanguage_code() {
		return language_code;
	}

	public void setLanguage_code(String language_code) {
		this.language_code = language_code;
	}

	public String getLanguage_name() {
		return language_name;
	}

	public void setLanguage_name(String language_name) {
		this.language_name = language_name;
	}
	
}

/*
 *  dump
 * */
