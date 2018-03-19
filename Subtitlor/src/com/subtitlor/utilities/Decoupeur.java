package com.subtitlor.utilities;

import java.util.ArrayList;
import java.util.List;



public class Decoupeur {
	
	//private int champ;
	private String chaine;
	List tableau = new ArrayList();
	
	//private ArrayList<String> oriSubtitles = null;
	
	public Decoupeur (ArrayList<String> listeoriginale) {
		
		ArrayList<String> oriSubtitles = listeoriginale;
		
		for (int i = 0; i < oriSubtitles.size(); i ++)
		{
			//System.out.println("ligne" + i + "=" + oriSubtitles.get(i));
			
			chaine = oriSubtitles.get(i);
			if(!chaine.equals("")) {
				
				//System.out.println("ligne" + i + "=" + chaine);
				tableau.add(chaine);
				
			}else {
				//System.out.println("ligne Vide" + i + "=" + oriSubtitles.get(i));
				Implementeur implementeur = new Implementeur(tableau);
				tableau.clear();
				
			}
			
		}
		
		
	}

}
