package com.subtitlor.utilities;

import java.util.ArrayList;
import java.util.List;



public class TriTraduction {
	
	
	private String chaine;
	List tableau = new ArrayList();
	
	
	
	public TriTraduction (String[] tabvalues) {
		
		String[] tradSubtitles = tabvalues;
		
		for (int i = 0; i < tradSubtitles.length; i ++)
		{
			
			
			chaine = tradSubtitles[i];
			if(!chaine.equals("")) {
				
				
				tableau.add(chaine);
				
			}else {
				
				Traducteur traducteur = new Traducteur(tableau);
				tableau.clear();
				
			}
			
		}
		
		
	}

}

