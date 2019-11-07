package com.project.contrader.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Investimento entity.
 */
public class InvestimentoDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer budget;

    @NotNull
    private Integer durata;

    @NotNull
    private Integer rischio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public Integer getRischio() {
        return rischio;
    }

    public void setRischio(Integer rischio) {
        this.rischio = rischio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InvestimentoDTO investimentoDTO = (InvestimentoDTO) o;
        if (investimentoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), investimentoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "InvestimentoDTO{" +
            "id=" + getId() +
            ", budget=" + getBudget() +
            ", durata=" + getDurata() +
            ", rischio=" + getRischio() +
            "}";
    }
}
