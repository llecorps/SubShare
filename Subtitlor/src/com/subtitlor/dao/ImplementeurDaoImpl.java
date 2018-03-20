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

	public void ajouterChamp(String champ, String time, String chaine1, String chaine2) {
	
		
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO original(champ,time, texteori1, texteori2) VALUES(?,?,?,?);");
            
            preparedStatement.setString(1,champ);
            preparedStatement.setString(2,time);
            preparedStatement.setString(3,chaine1);
            preparedStatement.setString(4,chaine2);
            

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
