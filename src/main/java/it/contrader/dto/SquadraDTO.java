
public class SquadraDTO {
	private String nomeSquadra;
	private float rating;

	public SquadraDTO() {
		
	}
	public SquadraDTO(String nomeSquadra, float rating) {
		
	this.nomeSquadra = nomeSquadra;
	this.rating = rating;
	}

	public String getNomeSquadra() {
	return nomeSquadra;
	}

	public float getRating() {
	return rating;	
	}
	@Override
	public String toString () {
	return this.nomeSquadra + "/t"	+ this.rating;
	}
}
