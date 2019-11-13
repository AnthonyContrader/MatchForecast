package com.matchforecast.contrader.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Historical.
 */
@Entity
@Table(name = "historical")
public class Historical implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "wins", nullable = false)
    private Integer wins;

    @NotNull
    @Column(name = "lose", nullable = false)
    private Integer lose;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWins() {
        return wins;
    }

    public Historical wins(Integer wins) {
        this.wins = wins;
        return this;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLose() {
        return lose;
    }

    public Historical lose(Integer lose) {
        this.lose = lose;
        return this;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
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
        Historical historical = (Historical) o;
        if (historical.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), historical.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Historical{" +
            "id=" + getId() +
            ", wins=" + getWins() +
            ", lose=" + getLose() +
            "}";
    }
}
