package DAO;

import java.util.List;

import Entity.Area;

public interface IAreaDAO {
	List<Area> searchArea();
	int searchMaxId();
    void addArea(Area area);
    void subArea(final Area area);
    void updateArea(final Area area);
}
