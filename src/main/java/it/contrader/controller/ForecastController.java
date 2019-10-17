package it.contrader.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ForecastDTO;
import it.contrader.service.ForecastService;

@Controller
@RequestMapping("/forecast")
public class ForecastController {
	
	@Autowired
	private ForecastService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "forecasts";
	}
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("codiceForecast") long codiceForecast) {
		service.delete(codiceForecast);
		setAll(request);
		return "forecasts";
	}
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("codiceForecast") long codiceForecast) {
		request.getSession().setAttribute("dto", service.read(codiceForecast));
		return "updateforecast";
	}
	@PostMapping("/update")
	public String update(HttpServletRequest request,@RequestParam("codiceForecast") long codiceForecast, @RequestParam("id") long id,
			@RequestParam("investimento") float investimento,@RequestParam("guadagno") float guadagno,
			@RequestParam("pRischio") float pRischio,@RequestParam("wallet") float wallet,@RequestParam("durata") String durata) {

		ForecastDTO dto = new ForecastDTO();
		dto.setCodiceForecast(codiceForecast);
		dto.setId(id);
		dto.setInvestimento(investimento);
		dto.setGuadagno(guadagno);
		dto.setPRischio(pRischio);
		dto.setWallet(wallet);
		dto.setDurata(durata);
		service.update(dto);
		setAll(request);
		return "forecasts";

	}
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("id") long id,
			@RequestParam("investimento") float investimento, @RequestParam("guadagno") float guadagno,
			@RequestParam("pRischio") float pRischio,@RequestParam("wallet") float wallet,@RequestParam("durata") String durata) {
		ForecastDTO dto = new ForecastDTO();
		dto.setId(id);
		dto.setInvestimento(investimento);
		dto.setGuadagno(guadagno);
		dto.setPRischio(pRischio);
		dto.setWallet(wallet);
		dto.setDurata(durata);
		service.insert(dto);
		setAll(request);
		return "forecasts";
	}
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("codiceForecast") long codiceForecast) {
		request.getSession().setAttribute("dto", service.read(codiceForecast));
		return "readforecast";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
