package com.matchforecast.contrader.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Partita.
 */
@Entity
@Table(name = "partita")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Partita implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "jhi_date", nullable = false)
    private String date;

    @NotNull
    @Column(name = "win", nullable = false)
    private Integer win;

    @NotNull
    @Column(name = "draw", nullable = false)
    private Integer draw;

    @NotNull
    @Column(name = "lose", nullable = false)
    private Integer lose;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("")
    private Squadra team1;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("")
    private Squadra squadra;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public Partita date(String date) {
        this.date = date;
        return this;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getWin() {
        return win;
    }

    public Partita win(Integer win) {
        this.win = win;
        return this;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getDraw() {
        return draw;
    }

    public Partita draw(Integer draw) {
        this.draw = draw;
        return this;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLose() {
        return lose;
    }

    public Partita lose(Integer lose) {
        this.lose = lose;
        return this;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public Squadra getTeam1() {
        return team1;
    }

    public Partita team1(Squadra squadra) {
        this.team1 = squadra;
        return this;
    }

    public void setTeam1(Squadra squadra) {
        this.team1 = squadra;
    }

    public Squadra getSquadra() {
        return squadra;
    }

    public Partita squadra(Squadra squadra) {
        this.squadra = squadra;
        return this;
    }

    public void setSquadra(Squadra squadra) {
        this.squadra = squadra;
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
        Partita partita = (Partita) o;
        if (partita.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), partita.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Partita{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            ", win=" + getWin() +
            ", draw=" + getDraw() +
            ", lose=" + getLose() +
            "}";
    }
}
