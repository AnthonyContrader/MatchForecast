package it.contrader.model;

public class Partita {

     private int id ;
	 private String squadra1 ;
     private String squadra2;
     private int orario ;
     private int data ;
     private int goalCasa;
     private int goalTrasferta;

     public Partita(){
    	
    	 
}



public Partita (String squadra1, String squadra2 ,int orario , int data , int goalCasa, int goalTrasferta ) {
    	  
	this.squadra1 = squadra1;
 	this.squadra2 = squadra2;
    this.data = data ;
    this.orario = orario ;
    this.goalCasa = goalCasa;
    this.goalTrasferta = goalTrasferta;

     
}
public Partita ( int id  , String squadra1, String squadra2 ,int orario , int data , int goalCasa, int goalTrasferta ) {
	this.id = id ;  
	this.squadra1 = squadra1;
 	this.squadra2 = squadra2;
    this.data = data ;
    this.orario = orario ;
    this.goalCasa = goalCasa;
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

	return this.getId() + "\t" + this.getSquadra1() + "\t" + this.getSquadra2() + "\t" + this.getOrario() + "\t" + this.getData() + "\t" + this.getGoalCasa() + "\t"+ this.getGoalTrasferta();

}

@Override
public boolean equals(Object obj) {
	if(this == obj)
		return true;
	if(obj==null)
		return false;
	if(getClass()!= obj.getClass())
		return false;
	Partita other = (Partita) obj;
	if (id != other.id)
		return false;
	if(squadra1.equals(other.getSquadra1()))
		return false;
	if(squadra2!= other.getSquadra2())
		return false;
	if(data == 0) {
		if(other.data != 0)
			return false;
	}else if (data != other.data)
		return false;
	if(orario==0) {
		if(other.orario!=0)
			return false;
	}else if (orario != other.orario)
		return false;
	if (goalCasa == 0) {
		if (other.goalCasa != 0)
		return false;
		} else if (goalCasa != other.goalCasa)
		return false;
	if (goalTrasferta == 0) {
		if (other.goalTrasferta != 0)
		return false;
		} else if (goalTrasferta != other.goalTrasferta)
		return false;
	return true;
	
}
}