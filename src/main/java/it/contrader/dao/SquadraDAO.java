package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Squadra;

public class SquadraDAO {
	private final String QUERY_ALL = "SELECT * FROM squadra";
	private final String QUERY_CREATE ="INSERT INTO squadra (nomeSquadra,numGiocatori,rating,vittorieCasa,vittorieEsterne,sconfitteCasa,sconfitteEsterne,pareggiCasa,pareggiEsterne) VALUES (?,?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM squadra WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE squadra SET nomeSquadra=?, numGiocatori=?, rating=? ,vittorieCasa=?, vittorieEsterne=?, sconfitteCasa=?, sconfitteEsterne=?, pareggiCasa=?, pareggiEsterne=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM squadra WHERE id=?";
	
public List<Squadra> getAll() {
	List<Squadra> squadraList = new ArrayList<>();
	Connection connection = ConnectionSingleton.getInstance();
	try {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(QUERY_ALL);
		Squadra squadra;
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String nomeSquadra = resultSet.getString("nomeSquadra");
			int numGiocatori = resultSet.getInt("numGiocatori");
			float rating = resultSet.getFloat("rating");
			int vittorieCasa = resultSet.getInt("vittorieCasa");
			int vittorieEsterne = resultSet.getInt("vittorieEsterne");
			int sconfitteCasa = resultSet.getInt("sconfitteCasa");
			int sconfitteEsterne = resultSet.getInt("sconfitteEsterne");
			int pareggiCasa = resultSet.getInt("pareggiCasa");
			int pareggiEsterne = resultSet.getInt("pareggiEsterne");
			squadra = new Squadra(nomeSquadra,numGiocatori,rating,vittorieCasa,vittorieEsterne,sconfitteCasa,sconfitteEsterne,pareggiCasa,pareggiEsterne);
			squadra.setId(id);
			squadraList.add(squadra);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return squadraList;
}
public boolean insert(Squadra squadraToInsert) {
	Connection connection = ConnectionSingleton.getInstance();
	try {	
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
		preparedStatement.setString(1, squadraToInsert.getNomeSquadra());
		preparedStatement.setInt(2, squadraToInsert.getNumGiocatori());
		preparedStatement.setFloat(3, squadraToInsert.getRating());
		preparedStatement.setInt(4, squadraToInsert.getVittorieCasa());
		preparedStatement.setInt(5, squadraToInsert.getVittorieEsterne());
		preparedStatement.setInt(6, squadraToInsert.getSconfitteCasa());
		preparedStatement.setInt(7, squadraToInsert.getSconfitteEsterne());
		preparedStatement.setInt(8, squadraToInsert.getPareggiCasa());
		preparedStatement.setInt(9, squadraToInsert.getPareggiEsterne());
		preparedStatement.execute();
		return true;
	} catch (SQLException e) {
		return false;
	}
}
	public Squadra read(int squadraId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, squadraId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String nomeSquadra;
			int numGiocatori,vittorieCasa,vittorieEsterne,sconfitteCasa,sconfitteEsterne,pareggiCasa,pareggiEsterne;
			float rating;
			nomeSquadra = resultSet.getString("nomeSquadra");
			numGiocatori = resultSet.getInt("numGiocatori");
			rating = resultSet.getFloat("rating");
			vittorieCasa = resultSet.getInt("vittorieCasa");
			vittorieEsterne = resultSet.getInt("vittorieEsterne");
			sconfitteCasa = resultSet.getInt("sconfitteCasa");
			sconfitteEsterne = resultSet.getInt("sconfitteEsterne");
			pareggiCasa = resultSet.getInt("pareggiCasa");
			pareggiEsterne = resultSet.getInt("pareggiEsterne");
			Squadra squadra = new Squadra(nomeSquadra,numGiocatori,rating,vittorieCasa,vittorieEsterne,sconfitteCasa,sconfitteEsterne,pareggiCasa,pareggiEsterne);
			squadra.setId(resultSet.getInt("id"));
			
			return squadra;
		} catch (SQLException e) {
			return null;
		}

	
}
	public boolean update(Squadra squadraToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		
		if (squadraToUpdate.getId() == 0)
			return false;

		Squadra squadraRead = read(squadraToUpdate.getId());
		if (!squadraRead.equals(squadraToUpdate)) {
			try {
				
				if (squadraToUpdate.getNomeSquadra() == null || squadraToUpdate.getNomeSquadra().equals("")) {
					squadraToUpdate.setNomeSquadra(squadraRead.getNomeSquadra());
				}

				if (squadraToUpdate.getNumGiocatori() == 0 ) {
					squadraToUpdate.setNumGiocatori(squadraRead.getNumGiocatori());
				}

				if (squadraToUpdate.getRating() == 0 ) {
					squadraToUpdate.setRating(squadraRead.getRating());
				}
				
				if (squadraToUpdate.getVittorieCasa() == 0 ) {
					squadraToUpdate.setVittorieCasa(squadraRead.getVittorieCasa());
				}

				if (squadraToUpdate.getVittorieEsterne() == 0 ) {
					squadraToUpdate.setVittorieEsterne(squadraRead.getVittorieEsterne());
				}

				if (squadraToUpdate.getSconfitteCasa() == 0 ) {
					squadraToUpdate.setSconfitteCasa(squadraRead.getSconfitteCasa());
				}
				
				if (squadraToUpdate.getSconfitteEsterne() == 0 ) {
					squadraToUpdate.setSconfitteEsterne(squadraRead.getSconfitteEsterne());
				}

				if (squadraToUpdate.getPareggiCasa() == 0 ) {
					squadraToUpdate.setPareggiCasa(squadraRead.getPareggiCasa());
				}

				if (squadraToUpdate.getPareggiEsterne() == 0 ) {
					squadraToUpdate.setPareggiEsterne(squadraRead.getPareggiEsterne());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, squadraToUpdate.getNomeSquadra());
				preparedStatement.setInt(2, squadraToUpdate.getNumGiocatori());
				preparedStatement.setFloat(3, squadraToUpdate.getRating());
				preparedStatement.setInt(4, squadraToUpdate.getVittorieCasa());
				preparedStatement.setInt(5, squadraToUpdate.getVittorieEsterne());
				preparedStatement.setInt(6, squadraToUpdate.getSconfitteCasa());
				preparedStatement.setInt(7, squadraToUpdate.getSconfitteEsterne());
				preparedStatement.setInt(8, squadraToUpdate.getPareggiCasa());
				preparedStatement.setInt(9, squadraToUpdate.getPareggiEsterne());
				preparedStatement.setInt(10, squadraToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}
		
	return false;
	}
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
}	