package com.matchforecast.contrader.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Historical entity.
 */
public class HistoricalDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer wins;

    @NotNull
    private Integer lose;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HistoricalDTO historicalDTO = (HistoricalDTO) o;
        if (historicalDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), historicalDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "HistoricalDTO{" +
            "id=" + getId() +
            ", wins=" + getWins() +
            ", lose=" + getLose() +
            "}";
    }
}
