package com.subtitlor.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.subtitlor.utilities.Implementeur;

public class ImplementeurDaoImpl implements ImplementeurDao {
	
	

	 private  DaoFactory daoFactory;

	 ImplementeurDaoImpl(DaoFactory daoFactory) {
	        this.daoFactory = daoFactory;
	    }

	public void ajouterChamp(String implementeur) {
		
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        System.out.println("INSERT champ =" + implementeur);

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO translation(champ) VALUES(?);");
            preparedStatement.setString(1,implementeur);
            

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void ajouterTime(String implementeur) {
		
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        System.out.println("INSERT time =" + implementeur);

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO translation(time) VALUES(?);");
            preparedStatement.setString(1,implementeur);
            

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public List<Implementeur> lister() {
		// TODO Auto-generated method stub
		return null;
	}

}
