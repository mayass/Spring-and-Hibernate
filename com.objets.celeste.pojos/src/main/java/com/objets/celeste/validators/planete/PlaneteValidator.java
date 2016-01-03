package com.objets.celeste.validators.planete;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.objets.celeste.pojos.planete.Planete;

public class PlaneteValidator implements Validator {

    public boolean supports(Class planete) {
	// TODO Auto-generated method stub
	return Planete.class.equals(planete);
    }

    public void validate(Object obj, Errors e) {
	// TODO Auto-generated method stub
	ValidationUtils.rejectIfEmpty(e, "nom", "planete.nom.invalide");
	ValidationUtils.rejectIfEmpty(e, "couleur", "planete.couleur.invalide");
	Planete p = (Planete) obj;
	if (p.getRayon() < 0) {
	    e.rejectValue("rayon", "planete.rayon.invalide");
	}
    }

}
