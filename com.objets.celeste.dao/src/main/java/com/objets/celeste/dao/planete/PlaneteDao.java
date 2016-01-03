package com.objets.celeste.dao.planete;

import java.util.List;

import com.objets.celeste.pojos.planete.Planete;

public interface PlaneteDao {
    
    void save(Planete planete);

    void update(Planete planete);

    void delete(Planete planete);

    Planete searchPlanetById(String planeteId);
    
    List<Planete> loadAllPlanets();
    
}
