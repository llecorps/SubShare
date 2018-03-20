package com.subtitlor.utilities;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import com.subtitlor.dao.DaoFactory;
import com.subtitlor.dao.TraducteurDao;

public class Traducteur {
	
	
	
	private static String champ;
	private String time;
	private String texteori;
	private String chaine1;
	private String chaine2;
	
	
	private String str = "none";
	
        DaoFactory daoFactory = DaoFactory.getInstance();
        
        TraducteurDao traducteurDao = daoFactory.getTraducteurDao();
  
	


	public Traducteur (List tableau) {
		
		setChamp((String) tableau.get(0));
		setTime((String) tableau.get(1));
		setChaine1((String) tableau.get(2));
		
		
		
		
		if( tableau.size() == 3) {
			
			setChaine2((String) str);
			
			
		}else {
			setChaine2((String) tableau.get(3));
			
		}
		
		
		traducteurDao.ajouterChamp(getChamp(),getTime(),getChaine1(),getChaine2());
		
				
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
