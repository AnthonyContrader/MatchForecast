package com.matchforecast.contrader.service.mapper;

import com.matchforecast.contrader.domain.*;
import com.matchforecast.contrader.service.dto.InvestimentoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Investimento and its DTO InvestimentoDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface InvestimentoMapper extends EntityMapper<InvestimentoDTO, Investimento> {



    default Investimento fromId(Long id) {
        if (id == null) {
            return null;
        }
        Investimento investimento = new Investimento();
        investimento.setId(id);
        return investimento;
    }
}
