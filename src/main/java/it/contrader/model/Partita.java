package it.contrader.model;

public class Partita {

     private Squadra squadra1 ;
     private Squadra squadra2;
     private int orario ;
     private int data ;
     private String risultato; 

     public Partita(){
    	
    	 this.squadra1 = null;
    	 this.squadra2 = null;
    	 this.data = 0 ;
    	 this.orario = 0 ;
    	 this.risultato = null ;
}



public Partite (Squadra squadra1, Squadra squadra2 ,int orario , int data ,String risultato ) {
    	  
	this.squadra1 = squadra1;
 	this.squadra2 = squadra2;
    this.Data = data ;
    this.Orario = orario ;
    this.Risultato = risultato ;

     
}

public Squadra getsquadr1(){
	
	return squadra1;

 }


public void setsquadra1 (Squadra squadra1) {
            
	this.squadra1 = squadra1 ;
}

public Squadra getsquadr2(){
	
	return squadra2;

 }


public void setsquadra1 (Squadra squadra2) {
            
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

	return this.getsquadra1() + "\t" + this.getsquadra2() + "\t" + this.getOrario() + "\t" + this.getData() + "\t" + this.getRisultato();

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
	if(squadra1!= other.getsquadra1())
		return false;
	if(squadra2!= other.getsquadra2())
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