package com.matchforecast.contrader.service.mapper;

import com.matchforecast.contrader.domain.*;
import com.matchforecast.contrader.service.dto.HistoricalDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Historical and its DTO HistoricalDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface HistoricalMapper extends EntityMapper<HistoricalDTO, Historical> {



    default Historical fromId(Long id) {
        if (id == null) {
            return null;
        }
        Historical historical = new Historical();
        historical.setId(id);
        return historical;
    }
}
