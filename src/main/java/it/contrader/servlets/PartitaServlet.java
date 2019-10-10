package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.PartitaDTO;
import it.contrader.service.Service;
import it.contrader.service.PartitaService;


public class PartitaServlet extends HttpServlet {
      private static final long serialVersionUID =1L;



public PartitaServlet() {
	
}

public void updateList(HttpServletRequest request) {
   Service<PartitaDTO> service = new PartitaService() ;
   List<PartitaDTO>listDTO = service.getAll();
   request.setAttribute("list", listDTO);
}

@Override
public void service(HttpServletRequest request , HttpServletResponse response)throws ServletException, IOException {
     Service<PartitaDTO> service = new PartitaService();
     String mode = request.getParameter("mode");
     PartitaDTO dto;
     int id ;
     boolean ans;

 
  switch (mode.toUpperCase()) {
  
  case "PARTITALIST":
        
      updateList(request);
      getServletContext().getRequestDispatcher("/partita/partitamanager.jsp").forward(request, response);
	break;
  
  case "READ" :
        
        id = Integer.parseInt(request.getParameter("id"));
        dto = service.read(id);
        request.setAttribute("dto", dto);
    
        if (request.getParameter("update") == null) {
		 getServletContext().getRequestDispatcher("/partita/readpartita.jsp").forward(request, response);
    }
  
        else getServletContext().getRequestDispatcher("/partita/updatepartita.jsp").forward(request, response);
  
  
  break ;
  
  case "INSERT":
  
  String squadra1 = request.getParameter("squadra1").toString();
  String squadra2 =request.getParameter("squadra2").toString();
  int data =Integer.parseInt(request.getParameter("data").toString());
  int orario =Integer.parseInt(request.getParameter("orario").toString());
  int goalCasa =Integer.parseInt(request.getParameter("goalCasa").toString());
  int goalTrasferta =Integer.parseInt(request.getParameter("goalTrasferta").toString());
  dto = new PartitaDTO (squadra1,squadra2,data,orario,goalCasa,goalTrasferta);
  ans = service.insert(dto);
  request.setAttribute("ans", ans);
  updateList(request);
  getServletContext().getRequestDispatcher("/partita/partitamanager.jsp").forward(request, response);
	break;
  
  
  
  
  case "UPDATE":
		squadra1 = request.getParameter("squadra1");
		squadra2 = request.getParameter("squadra2");
		data = Integer.parseInt(request.getParameter("data"));
		orario = Integer.parseInt(request.getParameter("orario"));
		goalCasa = Integer.parseInt(request.getParameter("goalCasa"));
		goalTrasferta = Integer.parseInt(request.getParameter("goalTrasferta"));
		id = Integer.parseInt(request.getParameter("id"));
	
		dto = new PartitaDTO (squadra1,squadra2,data,orario,goalCasa,goalTrasferta);
		ans = service.update(dto);
		updateList(request);
		getServletContext().getRequestDispatcher("/partita/partitamanager.jsp").forward(request, response);
		break;

	case "DELETE":
		id = Integer.parseInt(request.getParameter("id"));
		ans = service.delete(id);
		request.setAttribute("ans", ans);
		updateList(request);
		getServletContext().getRequestDispatcher("/partita/partitamanager.jsp").forward(request, response);
		break;
  
  
  
  
  
  
  
  
  
  }
}
}
  