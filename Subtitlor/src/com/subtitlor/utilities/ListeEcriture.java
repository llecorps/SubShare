package com.subtitlor.utilities;

import java.io.Serializable;

public class ListeEcriture implements Serializable{
	
	private String champ;
	private String time;
	private String textetrad1;
	private String textetrad2;
	
	public ListeEcriture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getChamp() {
		return champ;
	}

	public void setChamp(String champ) {
		this.champ = champ;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTextetrad1() {
		return textetrad1;
	}

	public void setTextetrad1(String textetrad1) {
		this.textetrad1 = textetrad1;
	}

	public String getTextetrad2() {
		return textetrad2;
	}

	public void setTextetrad2(String textetrad2) {
		this.textetrad2 = textetrad2;
	}
	
	

}
