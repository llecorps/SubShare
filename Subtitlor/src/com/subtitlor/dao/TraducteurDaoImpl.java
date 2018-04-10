package com.subtitlor.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.subtitlor.utilities.ListeEcriture;
import com.subtitlor.utilities.ListerTraduction;
import com.subtitlor.utilities.Traducteur;

public class TraducteurDaoImpl implements TraducteurDao {
	
		
	    private DaoFactory daoFactory;

	    TraducteurDaoImpl(DaoFactory daoFactory) {
	        this.daoFactory = daoFactory;
	    }
	    
	    public void ajouterChamp(String champ, String datedeb, String datefin, String textetrad) {
	    	
			
			Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        
	     

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO traduction(champ,datedeb,datefin, textetrad) VALUES(?,?,?,?);");
	            
	            preparedStatement.setString(1,champ);
	            preparedStatement.setString(2,datedeb);
	            preparedStatement.setString(3,datefin);
	            preparedStatement.setString(4,textetrad);
	            

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
	    

	   
	    
	    @Override
	    public List<ListerTraduction> lister() {
	        List<ListerTraduction> traducteurs = new ArrayList<ListerTraduction>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	       try {
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            
	            resultat = statement.executeQuery("select * from traduction INNER JOIN  original ON traduction.id = original.id;");

	            while (resultat.next()) {
	                String champ = resultat.getString("champ");
	                String datedeb = resultat.getString("datedeb");
	                String datefin = resultat.getString("datefin");
	                String texteori = resultat.getString("texteori");
	                String textetrad = resultat.getString("textetrad");
	                
	            
	                               
	                ListerTraduction listraduction = new ListerTraduction();
	                listraduction.setChamp(champ);
	                listraduction.setDatedeb(datedeb);
	                listraduction.setDatefin(datefin);
	                listraduction.setTexteori(texteori);
	                listraduction.setTextetrad(textetrad);
	                
	                
	                traducteurs.add(listraduction);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return traducteurs;
	    } 

		@Override
		public List<ListeEcriture> Ecrire() {
			
			 List<ListeEcriture> traduction = new ArrayList<ListeEcriture>();
		        Connection connexion = null;
		        Statement statement = null;
		        ResultSet resultat = null;
		        ObjectOutputStream oos = null;
		        File f = new File ("testbck2.srt");
		        
			
		        try {
		            connexion = daoFactory.getConnection();
		            statement = connexion.createStatement();
		            resultat = statement.executeQuery("select * from traduction;");
		            
		            

		            while (resultat.next()) {
		                String champ = resultat.getString("champ");
		                String datedeb = resultat.getString("datedeb");
		                String datefin = resultat.getString("datefin");
		                String textetrad = resultat.getString("textetrad");
		                
		                String[] tabdata = { champ,datedeb, datefin, textetrad};
		                		
		               
		                
		                try {
				        	
		                	FileWriter fw = new FileWriter (f,true);
							
		                	for (String s : tabdata)
		                    {
		                        fw.write (String.valueOf (s));
		                        fw.write ("\r\n");
		                    }
		                	fw.close();
				        	 
						} catch (IOException e) {
							
							e.printStackTrace();
						}
				        
		                           
		                
		                
		                
		            }
		            
		            
		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        
		      
		        
		       
		        
		        return traduction;
		    } 

		

	
		
		

	}
	


