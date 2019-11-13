package com.matchforecast.contrader.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Investimento.
 */
@Entity
@Table(name = "investimento")
public class Investimento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "budget", nullable = false)
    private Integer budget;

    @NotNull
    @Column(name = "durata", nullable = false)
    private Integer durata;

    @NotNull
    @Column(name = "rischio", nullable = false)
    private Integer rischio;

    @NotNull
    @Column(name = "iduser", nullable = false)
    private Integer iduser;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBudget() {
        return budget;
    }

    public Investimento budget(Integer budget) {
        this.budget = budget;
        return this;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getDurata() {
        return durata;
    }

    public Investimento durata(Integer durata) {
        this.durata = durata;
        return this;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public Integer getRischio() {
        return rischio;
    }

    public Investimento rischio(Integer rischio) {
        this.rischio = rischio;
        return this;
    }

    public void setRischio(Integer rischio) {
        this.rischio = rischio;
    }

    public Integer getIduser() {
        return iduser;
    }

    public Investimento iduser(Integer iduser) {
        this.iduser = iduser;
        return this;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
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
        Investimento investimento = (Investimento) o;
        if (investimento.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), investimento.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Investimento{" +
            "id=" + getId() +
            ", budget=" + getBudget() +
            ", durata=" + getDurata() +
            ", rischio=" + getRischio() +
            ", iduser=" + getIduser() +
            "}";
    }
}
