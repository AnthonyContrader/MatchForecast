package com.matchforecast.contrader.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Schedina.
 */
@Entity
@Table(name = "schedina")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Schedina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "quota_1", nullable = false)
    private Double quota1;

    @NotNull
    @Column(name = "quota_x", nullable = false)
    private Double quotaX;

    @NotNull
    @Column(name = "quota_2", nullable = false)
    private Double quota2;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("")
    private Partita partita;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuota1() {
        return quota1;
    }

    public Schedina quota1(Double quota1) {
        this.quota1 = quota1;
        return this;
    }

    public void setQuota1(Double quota1) {
        this.quota1 = quota1;
    }

    public Double getQuotaX() {
        return quotaX;
    }

    public Schedina quotaX(Double quotaX) {
        this.quotaX = quotaX;
        return this;
    }

    public void setQuotaX(Double quotaX) {
        this.quotaX = quotaX;
    }

    public Double getQuota2() {
        return quota2;
    }

    public Schedina quota2(Double quota2) {
        this.quota2 = quota2;
        return this;
    }

    public void setQuota2(Double quota2) {
        this.quota2 = quota2;
    }

    public Partita getPartita() {
        return partita;
    }

    public Schedina partita(Partita partita) {
        this.partita = partita;
        return this;
    }

    public void setPartita(Partita partita) {
        this.partita = partita;
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
        Schedina schedina = (Schedina) o;
        if (schedina.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), schedina.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Schedina{" +
            "id=" + getId() +
            ", quota1=" + getQuota1() +
            ", quotaX=" + getQuotaX() +
            ", quota2=" + getQuota2() +
            "}";
    }
}
