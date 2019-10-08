package it.contrader.dto;

public class PartitaDTO {
	private int id;
    private String squadra1 ;
    private String squadra2;
    private int orario ;
    private int data ;
    private int goalCasa; 
    private int goalTrasferta; 

 public PartitaDTO() {
	 
 }
 
 public PartitaDTO (String squadra1, String squadra2 ,int orario , int data ,int goalCasa, int goalTrasferta ){
	  
		this.squadra1 = squadra1;
	 	this.squadra2 = squadra2;
	    this.data = data ;
	    this.orario = orario ;
	    this.goalCasa = goalCasa ;
	    this.goalTrasferta = goalTrasferta;

	     
	}
 
 public PartitaDTO ( int id  , String squadra1, String squadra2 ,int orario , int data ,int goalCasa, int goalTrasferta ) {
		this.id = id ;  
		this.squadra1 = squadra1;
	 	this.squadra2 = squadra2;
	    this.data = data ;
	    this.orario = orario ;
	    this.goalCasa = goalCasa ;
	    this.goalTrasferta = goalTrasferta;

	     
	}
 
 public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

 public String getSquadra1(){
		
		return this.squadra1;

	 }


	public void setSquadra1 (String squadra1) {
	            
		this.squadra1 = squadra1 ;
	}

	public String getSquadra2(){
		
		return this.squadra2;

	 }


	public void setSquadra2 (String squadra2) {
	            
		this.squadra2 = squadra2 ;
	}

	public int getOrario(){
		
		return this.orario;
	}


	public void setOrario (int orario) {
	    
		this.orario = orario ;

	}

	public int getData(){
		
		return this.data;

	}


	public void setData (int data) {
	    
		this.data = data ;
	}


	public int getGoalCasa(){
		
		return this.goalCasa;
	}

	public void setGoalCasa (int goalCasa) {
		this.goalCasa = goalCasa ;
	}

public int getGoalTrasferta(){
		
		return this.goalTrasferta;
	}

	public void setGoalTrasferta (int goalTrasferta) {
		this.goalTrasferta = goalTrasferta ;
	}
	
	@Override
	public String toString() {

		return this.getSquadra1() + "\t" + this.getSquadra2() + "\t" + this.getOrario() + "\t" + this.getData() + "\t" + this.getGoalCasa() + "\t" + this.getGoalTrasferta();


	}
}