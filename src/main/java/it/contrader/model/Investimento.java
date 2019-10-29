package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Investimento {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@ManyToOne
@JoinColumn(name = "idUtente", referencedColumnName = "id")
private Investimento user;

@ManyToOne
@JoinColumn(name = "idSchedina", referencedColumnName = "id")
private Schedina schedina;

@Column
private int budget;
private int durata;
private int fRischio;


}
