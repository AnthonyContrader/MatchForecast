package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Partita;


public class PartitaDAO {

	private final String QUERY_ALL = "SELECT * FROM partita";
	private final String QUERY_CREATE = "INSERT INTO partita (squadra1,squadra2, data, orario , risultato ) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM partita WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE partita SET squadra1=?, squadra2=?, data=?, orario=? ,risultato=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM partita WHERE id=?";

	public partitaDAO() {

	}

	public List<Partita> getAll() {
		List<User> partitaList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Partita partita;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String squadra1 = resultSet.getString("squadra1");
				String squadra2 = resultSet.getString("squadra2");
				int  data = resultSet.getInt("data");
				int  orario = resultSet.getInt("orario");
				String risultato = resultSet.getString("risultato");
				partita = new Partita(squadra1,squadra2,data,orario,risultato );
				partita.setId(id);
				partitaList.add(partita);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return partitaList;
	}

	public boolean insert(Partita partitaToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setSquadra1(1, userToInsert.getSquadra1());
			preparedStatement.setSquadra2(2, userToInsert.getSquadra2());
			preparedStatement.setInt(3, userToInsert.getData());
			preparedStatement.setInt(4, userToInsert.getOrario());
			preparedStatement.setString(5, userToInsert.getRisultato());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public User read(int userId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String squadra1,squadra2,data,orario,risultato;
            
			squadra1 = resultSet.getString("squadra1");
			squadra2 = resultSet.getString("squadra2");
			data = resultSet.getInt("data");
			orario = resultSet.getint("orario");
			risultato = resultSet.getString("risultato");
			Partita partita = new Partita(squadra1,squadra2,data,orario,risultato);
			partita.setId(resultSet.getInt("id"));

			return partita;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Partita partitaToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (partitaToUpdate.getId() == 0)
			return false;

		Partita partitaRead = read(partitaToUpdate.getId());
		if (!partitaRead.equals(partitaToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (partitaToUpdate.getSquadra1() == null || partitaToUpdate.getSquadra1().equals("")) {
					partitaToUpdate.setSquadra1(partitaRead.getSquadra1());
				}
				
				if (partitaToUpdate.getSquadra2() == null || partitaToUpdate.getSquadra2().equals("")) {
					partitaToUpdate.setSquadra2(partitaRead.getSquadra2());
				}

				if (partitaToUpdate.getData() == null || partitaToUpdate.getData().equals("")) {
					partitaToUpdate.setData(partitaRead.getData());
				}
				if (partitaToUpdate.getOrario() == null || partitaToUpdate.getOrario().equals("")) {
					partitaToUpdate.setOrario(partitaRead.getOrario());
				}
				if (partitaToUpdate.getRisultato() == null || partitaToUpdate.getRisultato().equals("")) {
					partitaToUpdate.setRisultato(partitaRead.getRisultato());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, partitaToUpdate.getSquadra1());
				preparedStatement.setString(2, partitaToUpdate.getSquadra2());
				preparedStatement.setInt(3, partitaToUpdate.getData());
				preparedStatement.setInt(4, partitaToUpdate.getOrario());
				preparedStatement.setString(5, partitaToUpdate.getRisultato());
				preparedStatement.setInt(6, partitaToUpdate.getId());
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
