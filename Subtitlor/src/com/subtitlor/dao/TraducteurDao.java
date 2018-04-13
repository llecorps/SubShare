package com.subtitlor.dao;

import java.sql.SQLException;
import java.util.List;

import com.subtitlor.utilities.ListeEcriture;
import com.subtitlor.utilities.ListerTraduction;
import com.subtitlor.utilities.Traducteur;

public interface TraducteurDao {
	   
	    //List<Traducteur> lister();
	    
	    List<ListerTraduction> lister();
	    List<ListeEcriture> Ecrire();
		//void ajouterChamp(String champ, String time, String chaine1, String chaine2);
		void ajouterChamp(String champ, String datedeb, String datefin, String textetrad) throws SQLException;
	}


