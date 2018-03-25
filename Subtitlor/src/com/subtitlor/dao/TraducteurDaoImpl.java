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
	    public List<ListerTraduction> lister() {
	        List<ListerTraduction> traducteurs = new ArrayList<ListerTraduction>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	       try {
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("select * from original NATURAL JOIN traduction;");

	            while (resultat.next()) {
	                String champ = resultat.getString("champ");
	                String time = resultat.getString("time");
	                String texteori1 = resultat.getString("texteori1");
	                String texteori2 = resultat.getString("texteori2");
	                String textetrad1 = resultat.getString("textetrad1");
	                String textetrad2 = resultat.getString("textetrad2");
	                
	                               
	                ListerTraduction listraduction = new ListerTraduction();
	                listraduction.setChamp(champ);
	                listraduction.setTime(time);
	                listraduction.setTexteori1(texteori1);
	                listraduction.setTexteori2(texteori2);
	                listraduction.setTextetrad1(textetrad1);
	                listraduction.setTextetrad2(textetrad2);
	                
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
		                String time = resultat.getString("time");
		                String textetrad1 = resultat.getString("textetrad1");
		                String textetrad2 = resultat.getString("textetrad2");
		                
		                String[] tabdata = { champ,time, textetrad1, textetrad2};
		                		
		                /*
		                ListeEcriture listeecriture = new ListeEcriture();
		                listeecriture.setChamp(champ);
		                listeecriture.setTime(time);
		                listeecriture.setTextetrad1(textetrad1);
		                listeecriture.setTextetrad2(textetrad2);*/
		                
		                try {
				        	/*
							oos = new ObjectOutputStream(
							        new BufferedOutputStream(
							          new FileOutputStream(
							            new File("testbck2.srt"))));
							
							oos.writeObject(listeecriture.getChamp());
							oos.writeObject(listeecriture.getTime());
							oos.writeObject(listeecriture.getTextetrad1());
							oos.writeObject(listeecriture.getTextetrad2());*/
		                	FileWriter fw = new FileWriter (f,true);
							
		                	for (String s : tabdata)
		                    {
		                        fw.write (String.valueOf (s));
		                        fw.write ("\r\n");
		                    }
		                	fw.close();
				        	 
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				        
		                
		                
		                
		                
		                //traduction.add(listeecriture);
		            }
		            
		            
		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        
		        
		        /*
		        for (int i = 0; i < traduction.size(); i ++)
	    		{
		        	try {
						oos.writeObject(traduction.get(i));
		        		
		        		
		        		
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	
	    		}*/
		        
		        
		       
		        
		        return traduction;
		    } 

		

	
		
		

	}
	


