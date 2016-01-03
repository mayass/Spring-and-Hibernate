package com.objets.celeste.bo.planete;

import java.util.List;

import com.objets.celeste.pojos.planete.Planete;

public interface PlaneteBo {
    
    void enregistrerPlanete(Planete planete);

    void miseAJourPlanete(Planete planete);

    void supprimerPlanete(Planete planete);

    Planete rechercherPlaneteParId(String planeteId);

    List<Planete> listerPlanetes();
    
}
