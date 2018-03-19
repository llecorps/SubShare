package com.subtitlor.dao;

import java.util.List;
import com.subtitlor.utilities.Traducteur;

public interface TraducteurDao {
	   
	    List<Traducteur> lister();
		void ajouter(Traducteur traducteur);
	}


