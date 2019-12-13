package Entity.formStreet;

import java.util.List;

import javax.validation.Valid;

public class UpdateStreetForm {
    @Valid
    private List<UpdateStreet> listStreet;

    public void setListStreet(final List<UpdateStreet> plistStreet) {
    	listStreet = plistStreet;
    }

    public List<UpdateStreet> getListStreet() {
        return listStreet;
    }
}
