package it.contrader.service;

import java.util.List;


public interface Service<DTO> {
	
	public List<DTO> getAll();
	
	public DTO read(int id);
	
	public boolean insert(DTO dto);
	
	public boolean update(DTO dto);
	
	public boolean delete(int id);

}
