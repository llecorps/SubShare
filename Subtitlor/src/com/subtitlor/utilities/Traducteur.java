package com.subtitlor.utilities;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import com.subtitlor.dao.DaoFactory;
import com.subtitlor.dao.TraducteurDao;

public class Traducteur {
	
	
	
	private static String champ;
	private String datedeb;
	private String datefin;
	private String textetrad;
	
	
	
	private String str = "none";
	
        DaoFactory daoFactory = DaoFactory.getInstance();
        
        TraducteurDao traducteurDao = daoFactory.getTraducteurDao();
  
	


	public Traducteur (List tableau) throws SQLException {
		
		setChamp((String) tableau.get(0));
		setDatedeb((String) tableau.get(1));
		setDatefin((String) tableau.get(2));
		setTextetrad((String) tableau.get(3));
		
		
		
		
		traducteurDao.ajouterChamp(getChamp(),getDatedeb(),getDatefin(),getTextetrad());
		
				
	}
	
	
	public static String getChamp() {
		return champ;
	}




	public static void setChamp(String champ) {
		Traducteur.champ = champ;
	}




	public String getDatedeb() {
		return datedeb;
	}




	public void setDatedeb(String datedeb) {
		this.datedeb = datedeb;
	}




	public String getDatefin() {
		return datefin;
	}




	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}




	public String getTextetrad() {
		return textetrad;
	}




	public void setTextetrad(String textetrad) {
		this.textetrad = textetrad;
	}
	
	
}
