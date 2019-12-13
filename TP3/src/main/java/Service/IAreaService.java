package Service;

import java.util.List;

import Entity.Area;

public interface IAreaService {
    List<Area> searchArea();
    int searchMaxId();
    void addArea(int id, int id_area, int id_country, long language_id, String area_label);
    void subArea(final Integer AreaId);
    void updateArea(final List<Area> pListArea);
}
