package com.subtitlor.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.subtitlor.utilities.Implementeur;
import com.subtitlor.utilities.ListerOriginal;
import com.subtitlor.utilities.ListerTraduction;

public class ImplementeurDaoImpl implements ImplementeurDao {
	
	

	 private  DaoFactory daoFactory;
	 Connection connexion = null;

	 ImplementeurDaoImpl(DaoFactory daoFactory) {
	        this.daoFactory = daoFactory;
	       
	    }

	
		
	public void ajouterChamp(String champ, String datedeb,String datefin, String chaine1, String chaine2) throws SQLException {
	
		
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        
        String chaine = chaine1 + chaine2;
        System.out.println("ImplDAO:"+chaine);
        

        try {
            connexion = daoFactory.getConnection();
          
            preparedStatement = connexion.prepareStatement("INSERT INTO original(champ,datedeb, datefin, texteori) VALUES(?,?,?,?);");
            
            preparedStatement.setString(1,champ);
            
            preparedStatement.setString(2,datedeb);
            preparedStatement.setString(3,datefin);
            preparedStatement.setString(4,chaine);
            
            

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connexion.close();
	}
	
	
	@Override
	public List<ListerOriginal> lister() {
		
		List<ListerOriginal> original = new ArrayList<ListerOriginal>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

       try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("select * from original;");

            while (resultat.next()) {
                String champ = resultat.getString("champ");
                String datedeb = resultat.getString("datedeb");
                String datefin = resultat.getString("datefin");
                String texteori = resultat.getString("texteori");
                                
                      
                
                ListerOriginal listoriginal = new ListerOriginal();
                listoriginal.setChamp(champ);
                listoriginal.setDatedeb(datedeb);
                listoriginal.setDatefin(datefin);
                listoriginal.setTexteori(texteori);
                
                
                original.add(listoriginal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return original;
	}

}
