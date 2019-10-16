package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

	public enum Usertype {
		ADMIN, USER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String username;

	private String password;

	private Usertype usertype;
	
	@Column(name = "wSummary")
	
	private float wSummary;
	
	@Column(name = "mSummary")
	private float mSummary;
	
	@Column(name = "aSummary")
	private float aSummary;
	
	@Column(name = "wallet")
	private float wallet;

	//@OneToMany(mappedBy="user")
    //private Set<Forecast> forecast;
	
}
