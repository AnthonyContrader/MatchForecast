package it.contrader.dto;

public class PartitaDTO {
	private int id;
    private String squadra1 ;
    private String squadra2;
    private int orario ;
    private int data ;
    private String risultato; 


 public PartitaDTO() {
	 
 }
 
 public PartitaDTO (String squadra1, String squadra2 ,int orario , int data ,String risultato ){
	  
		this.squadra1 = squadra1;
	 	this.squadra2 = squadra2;
	    this.data = data ;
	    this.orario = orario ;
	    this.risultato = risultato ;

	     
	}
 
 public PartitaDTO ( int id  , String squadra1, String squadra2 ,int orario , int data ,String risultato ) {
		this.id = id ;  
		this.squadra1 = squadra1;
	 	this.squadra2 = squadra2;
	    this.data = data ;
	    this.orario = orario ;
	    this.risultato = risultato ;

	     
	}
 
 public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

 public String getSquadra1(){
		
		return squadra1;

	 }


	public void setSquadra1 (String squadra1) {
	            
		this.squadra1 = squadra1 ;
	}

	public String getSquadra2(){
		
		return squadra2;

	 }


	public void setSquadra2 (String squadra2) {
	            
		this.squadra2 = squadra2 ;
	}

	public int getOrario(){
		
		return orario;
	}


	public void setOrario (int orario) {
	    
		this.orario = orario ;

	}

	public int getData(){
		
		return data;

	}


	public void setData (int data) {
	    
		this.data = data ;
	}


	public String getRisultato(){
		
		return risultato;
	}

	public void setRisultato (String risultato) {
	    this.risultato = risultato ;
	}

	@Override
	public String toString() {

		return this.getSquadra1() + "\t" + this.getSquadra2() + "\t" + this.getOrario() + "\t" + this.getData() + "\t" + this.getRisultato();


	}
}