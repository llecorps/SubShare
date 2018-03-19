package com.subtitlor.utilities;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.subtitlor.dao.DaoFactory;
import com.subtitlor.dao.ImplementeurDao;
import com.subtitlor.dao.ImplementeurDaoImpl;

public class Implementeur {
	
	
	private static String champ;
	private String time;
	private String texteori;
	private String chaine1;
	private String chaine2;
	//private DaoFactory daoFactory;
	//private ImplementeurDao implementeurDao;
	
	
	
        DaoFactory daoFactory = DaoFactory.getInstance();
        
	ImplementeurDao implementeurDao = daoFactory.getImplementeurDao();
  
	


	public Implementeur (List tableau) {
		
		
		
		for (int i = 0; i < tableau.size(); i ++) {
			
			if(i == 0) {
				setChamp((String) tableau.get(0));
				implementeurDao.ajouterChamp(getChamp());
			}
			if(i == 1) {
				setTime((String) tableau.get(1));
				//System.out.println(getTime());
				implementeurDao.ajouterTime(getTime());
			}
			
			if(i == 2) {
				
				setChaine1((String) tableau.get(2));
				//System.out.println(getChaine1());
				
			}
			
			if(i == 3) {
				setChaine2((String) tableau.get(3));
				//System.out.println(getChaine2());
			}
			
					
					
		}
		
	}
	
	
	
	
	public String getChaine1() {
		return chaine1;
	}



	public void setChaine1(String chaine1) {
		this.chaine1 = chaine1;
	}



	public String getChaine2() {
		return chaine2;
	}



	public void setChaine2(String chaine2) {
		this.chaine2 = chaine2;
	}


	
	
	public  String getChamp() {
		
		return champ;
	}

	public void setChamp(String champ) {
		this.champ = champ;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTexteori() {
		return texteori;
	}

	public void setTexteori(String texteori) {
		this.texteori = texteori;
	}

	
}