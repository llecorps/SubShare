package com.subtitlor.dao;

import java.sql.SQLException;
import java.util.List;
import com.subtitlor.utilities.Implementeur;
import com.subtitlor.utilities.ListerOriginal;

public interface ImplementeurDao {
	
	
	
		    
		    
		    void ajouterChamp (String string, String string2, String string3, String string4, String string5) throws SQLException; 
		    
		    List<ListerOriginal> lister();
	



}
