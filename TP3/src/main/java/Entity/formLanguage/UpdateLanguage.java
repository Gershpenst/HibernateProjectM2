package Entity.formLanguage;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class UpdateLanguage {
	private int id;
	
	private long language_id;
	
    @NotEmpty(message="{modification.course.quantite.notempty}")
	private String language_code;
	
    @NotEmpty(message="{modification.course.quantite.notempty}")
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
