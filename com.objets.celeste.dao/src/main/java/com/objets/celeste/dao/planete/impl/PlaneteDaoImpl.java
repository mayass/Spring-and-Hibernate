package com.objets.celeste.dao.planete.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.objets.celeste.dao.planete.PlaneteDao;
import com.objets.celeste.pojos.planete.Planete;

public class PlaneteDaoImpl extends HibernateDaoSupport implements PlaneteDao {

    public void save(Planete planete) {
	// TODO Auto-generated method stub
	getHibernateTemplate().save(planete);
    }

    public void update(Planete planete) {
	// TODO Auto-generated method stub
	getHibernateTemplate().update(planete);
    }

    public void delete(Planete planete) {
	// TODO Auto-generated method stub
	getHibernateTemplate().delete(planete);
    }


    public Planete searchPlanetById(String planeteId) {
	// TODO Auto-generated method stub
	Planete p = new Planete();
	p = (Planete) getHibernateTemplate().get(Planete.class, planeteId);
	return p;
    }

    @SuppressWarnings("unchecked")
    public List<Planete> loadAllPlanets() {
	// TODO Auto-generated method stub
	List<Planete> list = new ArrayList<Planete>();
	list = getHibernateTemplate().loadAll(Planete.class);

	return list;
    }

}
