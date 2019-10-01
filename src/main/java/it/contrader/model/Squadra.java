
public class Squadra {
	private String NomeSquadra;
	private int NumGiocatori;
	final int Rating;
	private int VittorieCasa;
	private int VittorieEsterne;
	private int SconfitteCasa;
	private int SconfitteEsterne;
	private int Pareggi;
	public Squadra() {
		//costruttore vuoto//
	};
	public Squadra(String NomeSquadra,int NumGiocatori,int Rating,int VittorieCasa,int VittorieEsterne,int SconfitteCasa,int SconfitteEsterne,int Pareggi) {
		//costruttore per le istanze Squadra//
		
		this.NomeSquadra= NomeSquadra;
		this.NumGiocatori= NumGiocatori;
		this.Rating= Rating;
		this.VittorieCasa= VittorieCasa;
		this.VittorieEsterne= VittorieEsterne;
		this.SconfitteCasa= SconfitteCasa;
		this.SconfitteEsterne= SconfitteEsterne;
		this.Pareggi= Pareggi;
		
	}
	public String getNomeSquadra() {
		return this.NomeSquadra;
	}
public void setNomeSquadra(String NomeSquadra) {
	this.NomeSquadra= NomeSquadra;
	
	
}
public int getNumGiocatori () {
	return this.NumGiocatori;
}
public void setNumGiocatori(int NumGiocatori) {
	this.NumGiocatori= NumGiocatori;
	
}
public int getRating() {
	return this.Rating;
}
public void setRating(int Rating) {
	this.Rating=Rating;
}
public int getVittorieCasa () {
	return this.VittorieCasa;
}
public void setVittorieCasa(int VittorieCasa) {
	this.VittorieCasa= VittorieCasa;
	
}
public int getVittorieEsterne () {
	return this.VittorieEsterne;
}
public void setVittorieEsterne(int VittorieEsterne) {
	this.VittorieEsterne= VittorieEsterne;
	
}
public int getSconfitteCasa () {
	return this.SconfitteCasa;
}
public void setSconfitteCasa(int SconfitteCasa) {
	this.SconfitteCasa= SconfitteCasa;
	
}
public int getSconfitteEsterne () {
	return this.SconfitteEsterne;
}
public void setSconfitteEsterne(int SconfitteEsterne) {
	this.SconfitteEsterne= SconfitteEsterne;
	
}
public int getPareggi () {
	return this.Pareggi;
}
public void setPareggi(int Pareggi) {
	this.Pareggi= Pareggi;
	
}

@Override
public String toString() {
return NomeSquadra+ "t/"+ NumGiocatori + "t/" +Rating+ "t/"+VittorieCasa+"t/"+VittorieEsterne+"t/"+SconfitteCasa+"t/"+SconfitteEsterne+"t/"+Pareggi;

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
	if(NomeSquadra!= other.NomeSquadra())
		return false;
	if(NumGiocatori==null) {
		if(other.NumGiocatori!=null)
			return false;
	}else if (!NumGiocatori.equals(other.NumGiocatori))
		return false;
	if(Rating==null) {
		if(other.Rating!=null)
			return false;
	}else if (!Rating.equals(other.Rating))
		return false;
	if(VittorieCasa==null) {
		if(other.VittorieCasa!=null)
			return false;
	}else if (!VittorieCasa.equals(other.VittorieCasa))
		return false;
	if(VittorieEsterne==null) {
		if(other.VittorieEsterne!=null)
			return false;
	}else if (!VittorieEsterne.equals(other.VittorieEsterne))
		return false;
	if(SconfitteCasa==null) {
		if(other.SconfitteCasa!=null)
			return false;
	}else if (!SconfitteCasa.equals(other.SconfitteCasa))
		return false;
	if(SconfitteEsterne==null) {
		if(other.SconfitteEsterne!=null)
			return false;
	}else if (!SconfitteEsterne.equals(other.SconfitteEsterne))
		return false;
	if(Pareggi==null) {
		if(other.Pareggi!=null)
			return false;
	}else if (!Pareggi.equals(other.Pareggi))
		return false;
	return true;
	
}
}
