package com.subtitlor.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.subtitlor.utilities.Traducteur;

public class TraducteurDaoImpl implements TraducteurDao {
	
		
	    private DaoFactory daoFactory;

	    TraducteurDaoImpl(DaoFactory daoFactory) {
	        this.daoFactory = daoFactory;
	    }
	    
	    public void ajouterChamp(String champ, String time, String chaine1, String chaine2) {
	    	
			
			Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        
	       

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO traduction(champ,time, textetrad1, textetrad2) VALUES(?,?,?,?);");
	            
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
	    public List<Traducteur> lister() {
	        List<Traducteur> traducteurs = new ArrayList<Traducteur>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT * FROM translation;");

	            while (resultat.next()) {
	                String champ = resultat.getString("champ");
	                

	                //Traducteur traducteur = new Traducteur();
	                //traducteur.setTraduction(champ);
	                

	                //traducteurs.add(traducteur);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return traducteurs;
	    }

	
		
		

	}
	


