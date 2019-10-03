package it.contrader.model;

public class Partita {

     private int id ;
	 private String squadra1 ;
     private String squadra2;
     private int orario ;
     private int data ;
     private String risultato; 

     public Partita(){
    	
    	 
}



public Partita (String squadra1, String squadra2 ,int orario , int data ,String risultato ) {
    	  
	this.squadra1 = squadra1;
 	this.squadra2 = squadra2;
    this.data = data ;
    this.orario = orario ;
    this.risultato = risultato ;

     
}
public Partita ( int id  , String squadra1, String squadra2 ,int orario , int data ,String risultato ) {
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

	return this.getId() + "\t"  this.getSquadra1() + "\t" + this.getSquadra2() + "\t" + this.getOrario() + "\t" + this.getData() + "\t" + this.getRisultato();

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
	if (risultato == null) {
		if (other.risultato != null)
		return false;
		} else if (!risultato.equals(other.risultato))
		return false;
	return true;
	
}

}