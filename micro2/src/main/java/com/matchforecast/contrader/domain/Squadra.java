package com.matchforecast.contrader.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Squadra.
 */
@Entity
@Table(name = "squadra")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Squadra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name_team", nullable = false)
    private String nameTeam;

    @NotNull
    @Column(name = "num_players", nullable = false)
    private Integer numPlayers;

    @NotNull
    @Column(name = "rating", nullable = false)
    private Integer rating;

    @NotNull
    @Column(name = "wins", nullable = false)
    private Integer wins;

    @NotNull
    @Column(name = "defeats", nullable = false)
    private Integer defeats;

    @NotNull
    @Column(name = "draws", nullable = false)
    private Integer draws;

    @NotNull
    @Column(name = "totalgoal", nullable = false)
    private Integer totalgoal;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public Squadra nameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
        return this;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public Integer getNumPlayers() {
        return numPlayers;
    }

    public Squadra numPlayers(Integer numPlayers) {
        this.numPlayers = numPlayers;
        return this;
    }

    public void setNumPlayers(Integer numPlayers) {
        this.numPlayers = numPlayers;
    }

    public Integer getRating() {
        return rating;
    }

    public Squadra rating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getWins() {
        return wins;
    }

    public Squadra wins(Integer wins) {
        this.wins = wins;
        return this;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getDefeats() {
        return defeats;
    }

    public Squadra defeats(Integer defeats) {
        this.defeats = defeats;
        return this;
    }

    public void setDefeats(Integer defeats) {
        this.defeats = defeats;
    }

    public Integer getDraws() {
        return draws;
    }

    public Squadra draws(Integer draws) {
        this.draws = draws;
        return this;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public Integer getTotalgoal() {
        return totalgoal;
    }

    public Squadra totalgoal(Integer totalgoal) {
        this.totalgoal = totalgoal;
        return this;
    }

    public void setTotalgoal(Integer totalgoal) {
        this.totalgoal = totalgoal;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Squadra squadra = (Squadra) o;
        if (squadra.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), squadra.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Squadra{" +
            "id=" + getId() +
            ", nameTeam='" + getNameTeam() + "'" +
            ", numPlayers=" + getNumPlayers() +
            ", rating=" + getRating() +
            ", wins=" + getWins() +
            ", defeats=" + getDefeats() +
            ", draws=" + getDraws() +
            ", totalgoal=" + getTotalgoal() +
            "}";
    }
}
