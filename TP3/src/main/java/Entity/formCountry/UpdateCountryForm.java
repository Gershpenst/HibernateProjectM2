package Entity.formCountry;

import java.util.List;

import javax.validation.Valid;

public class UpdateCountryForm {
    @Valid
    private List<UpdateCountries> listCountries;

    public void setListCountries(final List<UpdateCountries> plistCountries) {
    	listCountries = plistCountries;
    }

    public List<UpdateCountries> getListCountries() {
        return listCountries;
    }
}
