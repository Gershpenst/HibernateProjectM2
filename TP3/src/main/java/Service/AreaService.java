package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.IAreaDAO;
import Entity.Area;

@Service
public class AreaService implements IAreaService{
	@Autowired
	private IAreaDAO areaDAO;
	
	public void setAreaDAO(IAreaDAO areaDAO) {
		this.areaDAO = areaDAO;
	}
	
	@Transactional(readOnly=true)
	public List<Area> searchArea(){
		List<Area> listArea = areaDAO.searchArea();
		return listArea;
	}
	
    @Transactional(readOnly=true)
    public int searchMaxId() {
    	int id = areaDAO.searchMaxId();
        return id;
    }
	
    @Transactional
	public void addArea(int id, int id_area, int id_country, long language_id, String area_label) {
		Area area = new Area();
		area.setId(id);
		area.setId_country(id_country);
		area.setLanguage_id(language_id);
		area.setId_area(id_area);
		area.setArea_label(area_label);
		
		areaDAO.addArea(area);		
    }
    
    @Transactional
    public void subArea(final Integer IdArea) {
        final Area lArea = new Area();
        lArea.setId(IdArea);

        areaDAO.subArea(lArea);
    }
    
    @Transactional
    public void updateArea(final List<Area> pListeArea) {
        for (final Area lArea : pListeArea) {
        	areaDAO.updateArea(lArea);
        }
    }

}
