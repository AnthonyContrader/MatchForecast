package it.contrader.model;

import javax.persistence.*;

import com.mysql.jdbc.Blob;

import it.contrader.model.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Team {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(unique = true)
private String nameTeam;

private int numPlayers;

private int rating;

private int wins;



private int defeats;


private int draws;

private int totalgoal;

//private Blob logo;

}
