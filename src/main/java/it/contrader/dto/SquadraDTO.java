package it.contrader.dto;
public class SquadraDTO {
	
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

	public SquadraDTO() {
		
	}
	
	public Squadra(String nomeSquadra, int numGiocatori, float rating, int vittorieCasa, int vittorieEsterne,
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




	public int getNumGiocatori() {
		return numGiocatori;
	}




	public float getRating() {
		return rating;
	}
	@Override
	public String toString() {
	return id+ "/t"+ nomeSquadra+ "t/"+ numGiocatori + "t/" +rating+ "t/"+vittorieCasa+"t/"+vittorieEsterne+"t/"+sconfitteCasa+"t/"+sconfitteEsterne+"t/"+pareggiCasa+"t/"+pareggiEsterne;
	}
}