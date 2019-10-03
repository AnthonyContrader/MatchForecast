package it.contrader.model;


public class Squadra {
	private int id;
	private String nomeSquadra;
	private int numGiocatori;
	private float rating;
	private int vittorieCasa;
	private int vittorieEsterne;
	private int sconfitteCasa;
	private int sconfitteEsterne;
	private int pareggiCasa;
	private int pareggiEsterne;

	public Squadra()
	{
		
	}


	public Squadra( String nomeSquadra, int numGiocatori, float rating, int vittorieCasa, int vittorieEsterne,
			int sconfitteCasa, int sconfitteEsterne, int pareggiCasa, int pareggiEsterne) {
		
		
		this.nomeSquadra = nomeSquadra;
		this.numGiocatori = numGiocatori;
		this.rating = rating;
		this.vittorieCasa = vittorieCasa;
		this.vittorieEsterne = vittorieEsterne;
		this.sconfitteCasa = sconfitteCasa;
		this.sconfitteEsterne = sconfitteEsterne;
		this.pareggiCasa = pareggiCasa;
		this.pareggiEsterne = pareggiEsterne;
	}

	

	
	
	
	
	
	
	public Squadra(int id, String nomeSquadra, int numGiocatori, float rating, int vittorieCasa, int vittorieEsterne,
			int sconfitteCasa, int sconfitteEsterne, int pareggiCasa, int pareggiEsterne) {
		
		this.id = id;
		this.nomeSquadra = nomeSquadra;
		this.numGiocatori = numGiocatori;
		this.rating = rating;
		this.vittorieCasa = vittorieCasa;
		this.vittorieEsterne = vittorieEsterne;
		this.sconfitteCasa = sconfitteCasa;
		this.sconfitteEsterne = sconfitteEsterne;
		this.pareggiCasa = pareggiCasa;
		this.pareggiEsterne = pareggiEsterne;
	}


public int getId() {
	return this.id;
}

public void setId(int id) {
	this.id = id;
}	

public int getVittorieCasa() {
	return vittorieCasa;
}




public void setVittorieCasa(int vittorieCasa) {
	this.vittorieCasa = vittorieCasa;
}




public int getVittorieEsterne() {
	return vittorieEsterne;
}




public void setVittorieEsterne(int vittorieEsterne) {
	this.vittorieEsterne = vittorieEsterne;
}




public int getSconfitteCasa() {
	return sconfitteCasa;
}




public void setSconfitteCasa(int sconfitteCasa) {
	this.sconfitteCasa = sconfitteCasa;
}




public int getSconfitteEsterne() {
	return sconfitteEsterne;
}




public void setSconfitteEsterne(int sconfitteEsterne) {
	this.sconfitteEsterne = sconfitteEsterne;
}




public int getPareggiCasa() {
	return pareggiCasa;
}




public void setPareggiCasa(int pareggiCasa) {
	this.pareggiCasa = pareggiCasa;
}




public int getPareggiEsterne() {
	return pareggiEsterne;
}




public void setPareggiEsterne(int pareggiEsterne) {
	this.pareggiEsterne = pareggiEsterne;
}




public String getNomeSquadra() {
	return nomeSquadra;
}


public void  setNomeSquadra(String nomeSquadra) {
	this.nomeSquadra= nomeSquadra;
}


public int getNumGiocatori() {
	return numGiocatori;
}

public void  setNumGiocatori(int numGiocatori) {
	this.numGiocatori= numGiocatori;
}


public float getRating() {
	return rating;
}


public void  setRating(float rating) {
	this.rating= rating;
}

@Override
public String toString() {
return id+ "/t"+ nomeSquadra+ "t/"+ numGiocatori + "t/" +rating+ "t/"+vittorieCasa+"t/"+vittorieEsterne+"t/"+sconfitteCasa+"t/"+sconfitteEsterne+"t/"+pareggiCasa+"t/"+pareggiEsterne;

}

@Override
public boolean equals(Object obj) {
	if(this == obj)
		return true;
	if(obj==null)
		return false;
	if(getClass()!= obj.getClass())
		return false;
	Squadra other = (Squadra) obj;
	if (id != other.id)
		return false;
	if(nomeSquadra!= other.getNomeSquadra())
		return false;
	if(numGiocatori == 0) {
		if(other.numGiocatori != 0)
			return false;
	}else if (numGiocatori != other.numGiocatori)
		return false;
	if(rating==0) {
		if(other.rating!=0)
			return false;
	}else if (rating != other.rating)
		return false;
	if(vittorieCasa==0) {
		if(other.vittorieCasa!=0)
			return false;
	}else if (vittorieCasa != other.vittorieCasa)
		return false;
	if(vittorieEsterne==0) {
		if(other.vittorieEsterne!= 0)
			return false;
	}else if (vittorieEsterne != other.vittorieEsterne)
		return false;
	if(sconfitteCasa==0) {
		if(other.sconfitteCasa!= 0)
			return false;
	}else if (sconfitteCasa != other.sconfitteCasa)
		return false;
	if(sconfitteEsterne==0) {
		if(other.sconfitteEsterne!=0)
			return false;
	}else if (sconfitteEsterne != other.sconfitteEsterne)
		return false;
	if(pareggiCasa==0) {
		if(other.pareggiCasa!=0)
			return false;
	}else if (pareggiCasa != other.pareggiCasa)
		return false;
	if(pareggiEsterne==0) {
		if(other.pareggiEsterne!=0)
			return false;
	}else if (pareggiEsterne != other.pareggiEsterne)
		return false;
	return true;
	
}
}
