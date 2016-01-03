package com.objets.celeste.pojos.planete;

import java.io.Serializable;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.objets.celeste.validators.planete.PlaneteValidator;

public class Planete implements Serializable{


    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    private String planeteID;
    private String nom;
    private String couleur;
    private Integer rayon;

    public String getPlaneteID() {
	return planeteID;
    }

    public void setPlaneteID(String planeteID) {
	this.planeteID = planeteID;
    }
    
    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public String getCouleur() {
	return couleur;
    }

    public void setCouleur(String couleur) {
	this.couleur = couleur;
    }

    public Integer getRayon() {
	return rayon;
    }

    public void setRayon(Integer rayon) {
	this.rayon = rayon;
    }

    public String toString() {

	return this.getClass().getName()

	+ "["
	
	+ "planeteID="+ this.planeteID
	
	+ ", nom=" + this.nom

	+ ", couleur=" + this.couleur

	+ ", rayon=" + this.rayon

	+ "]";

    }
    
    public Errors validate(Errors errors)
    {
	if(errors == null)
	{
	    errors = new BindException(this, Planete.class.getName());
	}
	
	ValidationUtils.invokeValidator(new PlaneteValidator(), this, errors);
	
	return errors;
    }
}
