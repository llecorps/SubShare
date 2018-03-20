package com.subtitlor.utilities;

import java.util.ArrayList;
import java.util.List;



public class TriOriginal {
	
	
	private String chaine;
	List tableau = new ArrayList();
	
	
	
	public TriOriginal (ArrayList<String> listeoriginale) {
		
		ArrayList<String> oriSubtitles = listeoriginale;
		
		for (int i = 0; i < oriSubtitles.size(); i ++)
		{
			
			
			chaine = oriSubtitles.get(i);
			if(!chaine.equals("")) {
				
				
				tableau.add(chaine);
				
			}else {
				
				Implementeur implementeur = new Implementeur(tableau);
				tableau.clear();
				
			}
			
		}
		
		
	}

}
