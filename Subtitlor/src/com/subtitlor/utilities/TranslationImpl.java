package com.subtitlor.utilities;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class TranslationImpl implements Serializable{
	
	
	
	
	ArrayList<String> listeTraduction = new ArrayList<String>();
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	
	public TranslationImpl() {
		
		super();
		
	}
	
	

	
	public void addlisteTraduction(String champ) {
	
		listeTraduction.add(champ);
}

	public ArrayList<String> getlisteTraduction(){
		return listeTraduction;
	}

}
