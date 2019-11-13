package com.matchforecast.contrader.web.rest.client;

import com.matchforecast.contrader.service.dto.InvestimentoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "investimento")
public interface InvestimentosServiceProxy {

    

    @RequestMapping(value = "/api/investimentoByUser/{id}")
    ResponseEntity<List<InvestimentoDTO>> getInvestimentosByUser(@PathVariable(value = "id") Long id);

/*  
    @RequestMapping(value = "/api/sometext/{varText}")
    ResponseEntity<String> getSomeText(@PathVariable("varText") String text);*/

}