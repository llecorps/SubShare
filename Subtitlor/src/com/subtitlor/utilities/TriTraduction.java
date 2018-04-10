package com.subtitlor.utilities;

import java.util.ArrayList;
import java.util.List;



public class TriTraduction {
	
	
	private String chaine;
	List tableau = new ArrayList();
	private int occ = 0;
	
	
	public TriTraduction (String[] tabvalues) {
		
		String[] tradSubtitles = tabvalues;
		
		for (int i = 0; i < tradSubtitles.length; i ++)
		{
			
			
			chaine = tradSubtitles[i];
			occ ++;	
			tableau.add(chaine);
					
			if( occ == 4) {
						
						
				Traducteur traducteur = new Traducteur(tableau);
				tableau.clear();
				occ = 0;
				
			}
		
			
		}
		
		
	}

}

