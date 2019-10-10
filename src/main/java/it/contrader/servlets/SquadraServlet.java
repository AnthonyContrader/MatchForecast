package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.SquadraDTO;
import it.contrader.service.Service;
import it.contrader.service.SquadraService;


public class SquadraServlet extends HttpServlet {
      private static final long serialVersionUID =1L;



public SquadraServlet() {
	
}

public void updateList(HttpServletRequest request) {
   Service<SquadraDTO> service = new SquadraService() ;
   List<SquadraDTO>listDTO = service.getAll();
   request.setAttribute("list", listDTO);
}

@Override
public void service(HttpServletRequest request , HttpServletResponse response)throws ServletException, IOException {
     Service<SquadraDTO> service = new SquadraService();
     String mode = request.getParameter("mode");
     SquadraDTO dto;
     int id ;
     boolean ans;

 
  switch (mode.toUpperCase()) {
  
  case "SQUADRALIST":
        
      updateList(request);
      getServletContext().getRequestDispatcher("/squadra/squadramanager.jsp").forward(request, response);
	break;
  
  case "READ" :
        
        id = Integer.parseInt(request.getParameter("id"));
        dto = service.read(id);
        request.setAttribute("dto", dto);
    
        if (request.getParameter("update") == null) {
		 getServletContext().getRequestDispatcher("/squadra/readpartita.jsp").forward(request, response);
    }
  
        else getServletContext().getRequestDispatcher("/squadra/updatepartita.jsp").forward(request, response);
  
  
  break ;
  
  case "INSERT":
  
  String nomeSquadra = request.getParameter("nomeSquadra");
  int numGiocatori =Integer.parseInt(request.getParameter("numGiocatori"));;
  float rating =Float.parseFloat(request.getParameter("rating"));
  int vittorieCasa =Integer.parseInt(request.getParameter("vittorieCasa"));
  int vittorieEsterne =Integer.parseInt(request.getParameter("vittorieEsterne"));
  int sconfitteCasa =Integer.parseInt(request.getParameter("sconfitteCasa"));
  int sconfitteEsterne =Integer.parseInt(request.getParameter("sconfitteEsterne"));
  int pareggiCasa =Integer.parseInt(request.getParameter("pareggiCasa"));
  int pareggiEsterne =Integer.parseInt(request.getParameter("pareggiEsterne"));
  dto = new SquadraDTO(nomeSquadra,numGiocatori,rating,vittorieCasa,vittorieEsterne,sconfitteCasa,sconfitteEsterne,pareggiCasa,pareggiEsterne);
  ans = service.insert(dto);
  request.setAttribute("ans", ans);
  updateList(request);
  getServletContext().getRequestDispatcher("/squadra/squadramanager.jsp").forward(request, response);
	break;
  
case "UPDATE":
	nomeSquadra = request.getParameter("nomeSquadra");
	numGiocatori =Integer.parseInt(request.getParameter("numGiocatori"));;
	rating =Float.parseFloat(request.getParameter("rating"));
	vittorieCasa =Integer.parseInt(request.getParameter("vittorieCasa"));
	vittorieEsterne =Integer.parseInt(request.getParameter("vittorieEsterne"));
	sconfitteCasa =Integer.parseInt(request.getParameter("sconfitteCasa"));
	sconfitteEsterne =Integer.parseInt(request.getParameter("sconfitteEsterne"));
	pareggiCasa =Integer.parseInt(request.getParameter("pareggiCasa"));
	pareggiEsterne =Integer.parseInt(request.getParameter("pareggiEsterne"));
	id = Integer.parseInt(request.getParameter("id"));
	

	dto = new SquadraDTO(id,nomeSquadra,numGiocatori,rating,vittorieCasa,vittorieEsterne,sconfitteCasa,sconfitteEsterne,pareggiCasa,pareggiEsterne);
	ans = service.update(dto);
	updateList(request);
	getServletContext().getRequestDispatcher("/squadra/squadramanager.jsp").forward(request, response);
	break;
	
case "DELETE":
	id = Integer.parseInt(request.getParameter("id"));
	ans = service.delete(id);
	request.setAttribute("ans", ans);
	updateList(request);
	getServletContext().getRequestDispatcher("/squadra/squadramanager.jsp").forward(request, response);
	break;
}
}
}  
