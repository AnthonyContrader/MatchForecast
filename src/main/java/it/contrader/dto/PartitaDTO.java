package it.contrader.dto;

public class PartitaDTO {
	
    private Squadra squadra1 ;
    private Squadra squadra2;
    private int orario ;
    private int data ;
    private String risultato; 


 public PartitaDTO() {
	 this.squadra1 = null;
	 this.squadra2 = null;
	 this.data = 0 ;
	 this.orario = 0 ;
	 this.risultato = null ;
 }
 
 public PartitaDTO (Squadra squadra1, Squadra squadra2 ,int orario , int data ,String risultato ){
	  
		this.squadra1 = squadra1;
	 	this.squadra2 = squadra2;
	    this.data = data ;
	    this.orario = orario ;
	    this.risultato = risultato ;

	     
	}

 public Squadra getsquadra1(){
		
		return squadra1;

	 }


	public void setsquadra1 (Squadra squadra1) {
	            
		this.squadra1 = squadra1 ;
	}

	public Squadra getsquadra2(){
		
		return squadra2;

	 }


	public void setsquadra2 (Squadra squadra2) {
	            
		this.squadra2 = squadra2 ;
	}

	public int getorario(){
		
		return orario;
	}


	public void setorario (int orario) {
	    
		this.orario = orario ;

	}

	public int getdata(){
		
		return data;

	}


	public void setdata (int data) {
	    
		this.data = data ;
	}


	public String getrisultato(){
		
		return risultato;
	}

	public void setrisultato (String risultato) {
	    this.risultato = risultato ;
	}

	@Override
	public String toString() {

		return this.getsquadra1() + "\t" + this.getsquadra2() + "\t" + this.getorario() + "\t" + this.getdata() + "\t" + this.getrisultato();


	}
}