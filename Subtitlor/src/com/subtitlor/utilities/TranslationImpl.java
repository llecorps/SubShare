package com.subtitlor.utilities;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class TranslationImpl implements Serializable{
	
	//private ArrayList<String> listeTraduction = null;
	
	
	ArrayList<String> listeTraduction = new ArrayList<String>();
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	
	public TranslationImpl() {
		
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*public void addTranslatedList(Traduction traduction) {
		
		translatedList.add(traduction);
	}
	
	public ArrayList<String> getTranslatedList(){
		return translatedList;
	}*/

	
	public void addlisteTraduction(String champ) {
	
		listeTraduction.add(champ);
}

	public ArrayList<String> getlisteTraduction(){
		return listeTraduction;
	}

}
