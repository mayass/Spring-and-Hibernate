package com.objets.celeste.bo.planete.impl;

import java.util.List;

import org.springframework.validation.Errors;
import com.objets.celeste.bo.planete.PlaneteBo;
import com.objets.celeste.dao.planete.PlaneteDao;
import com.objets.celeste.pojos.planete.Planete;

public class PlaneteBoImpl implements PlaneteBo {

    PlaneteDao planeteDao;

    public void setPlaneteDao(PlaneteDao planeteDao) {

	this.planeteDao = planeteDao;
    }

    public void enregistrerPlanete(Planete planete) {
	// TODO Auto-generated method stub
	Errors errors = validate(planete);
	if (errors.getErrorCount() == 0) {
	    planeteDao.save(planete);
	}
    }

    public void miseAJourPlanete(Planete planete) {
	// TODO Auto-generated method stub
	Errors errors = validate(planete);
	if (errors.getErrorCount() == 0) {
	    planeteDao.update(planete);
	}
    }

    public void supprimerPlanete(Planete planete) {
	// TODO Auto-generated method stub
	planeteDao.delete(planete);
    }

    public Planete rechercherPlaneteParId(String planeteId) {
	// TODO Auto-generated method stub
	return planeteDao.searchPlanetById(planeteId);
    }

    public List<Planete> listerPlanetes() {
	// TODO Auto-generated method stub
	return planeteDao.loadAllPlanets();
    }

    private Errors validate(final Planete planete) {
	return planete.validate(null);
    }

}
