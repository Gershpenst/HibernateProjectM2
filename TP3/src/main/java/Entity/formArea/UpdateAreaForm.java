package Entity.formArea;

import java.util.List;

import javax.validation.Valid;

public class UpdateAreaForm {
    @Valid
    private List<UpdateArea> listArea;

    public void setListArea(final List<UpdateArea> plistArea) {
    	listArea = plistArea;
    }

    public List<UpdateArea> getListArea() {
        return listArea;
    }
}
