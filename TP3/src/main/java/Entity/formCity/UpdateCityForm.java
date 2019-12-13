package Entity.formCity;

import java.util.List;

import javax.validation.Valid;

public class UpdateCityForm {
    @Valid
    private List<UpdateCity> listCity;

    public void setListCity(final List<UpdateCity> plistCity) {
    	listCity = plistCity;
    }

    public List<UpdateCity> getListCity() {
        return listCity;
    }
}
