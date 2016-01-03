package com.objets.celeste.dao.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;

public class IdentifiantPersonnalise implements IdentifierGenerator, Configurable {

    private String prefixObjet;
    private String nomTable;
    private int nombreParDefaut = 1;

    public Serializable generate(SessionImplementor sessionImplementor, Object arg1) throws HibernateException {
	// TODO Auto-generated method stub
	Connection connection = sessionImplementor.connection();

	try {
	    java.sql.PreparedStatement pst = connection.prepareStatement("select ID from "+nomTable+" order by DATE_CREAT desc limit 1");
	    ResultSet rs = pst.executeQuery();

	    if (rs != null && rs.next()) {
		
		String planeteId = rs.getString("ID");
		
		String prefix = planeteId.substring(0, 3);
		String str[] = planeteId.split(prefix);
		String digits = String.format("%05d", Integer.parseInt(str[1]) + 1);
		planeteId = prefix.concat(digits);

		return planeteId;
	    }
	    else
	    {
		return String.format("%s%05d", prefixObjet, nombreParDefaut);
	    }

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return null;
    }

    public void configure(Type arg0, Properties properties, Dialect arg2) throws MappingException {
	// TODO Auto-generated method stub
	prefixObjet = properties.getProperty("prefixObjet");
	nomTable = properties.getProperty("nomTable");
    }

}
