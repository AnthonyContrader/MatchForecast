package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Partita;


public class PartitaDAO implements DAO<Partita> {

	private final String QUERY_ALL = "SELECT * FROM partita";
	private final String QUERY_CREATE = "INSERT INTO partita (squadra1,squadra2, data, orario , golCasa,golTrasferta ) VALUES (?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM partita WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE partita SET squadra1=?, squadra2=?, data=?, orario=? ,golCasa=?,golTrasferta=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM partita WHERE id=?";

	public PartitaDAO() {

	}

	public List<Partita> getAll() {
		List<Partita> partitaList = new ArrayList<>();
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
				int goalCasa = resultSet.getInt("golCasa");
				int goalTrasferta = resultSet.getInt("golTrasferta");
				partita = new Partita(squadra1,squadra2,data,orario,goalCasa,goalTrasferta );
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
			preparedStatement.setString(1, partitaToInsert.getSquadra1());
			preparedStatement.setString(2, partitaToInsert.getSquadra2());
			preparedStatement.setInt(3, partitaToInsert.getData());
			preparedStatement.setInt(4, partitaToInsert.getOrario());
			preparedStatement.setInt(5, partitaToInsert.getGoalCasa());
			preparedStatement.setInt(6, partitaToInsert.getGoalTrasferta());
			preparedStatement.execute();
			System.out.println(partitaToInsert);
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Partita read(int partitaId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, partitaId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String squadra1,squadra2;
            int data,orario,goalCasa,goalTrasferta;
			squadra1 = resultSet.getString("squadra1");
			squadra2 = resultSet.getString("squadra2");
			data = resultSet.getInt("data");
			orario = resultSet.getInt("orario");
			goalCasa = resultSet.getInt("golCasa");
			goalTrasferta = resultSet.getInt("golTrasferta");
			Partita partita = new Partita(squadra1,squadra2,data,orario,goalCasa,goalTrasferta);
			partita.setId(resultSet.getInt("id"));

			return partita;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Partita partitaToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		
		if (partitaToUpdate.getId() == 0)
			return false;

		Partita partitaRead = read(partitaToUpdate.getId());
		if (!partitaRead.equals(partitaToUpdate)) {
			try {
				
				if (partitaToUpdate.getSquadra1() == null || partitaToUpdate.getSquadra1().equals("")) {
					partitaToUpdate.setSquadra1(partitaRead.getSquadra1());
				}
				
				if (partitaToUpdate.getSquadra2() == null || partitaToUpdate.getSquadra2().equals("")) {
					partitaToUpdate.setSquadra2(partitaRead.getSquadra2());
				}

				if (partitaToUpdate.getData() == 0 ) {
					partitaToUpdate.setData(partitaRead.getData());
				}
				if (partitaToUpdate.getOrario() == 0 ) {
					partitaToUpdate.setOrario(partitaRead.getOrario());
				}
				if (partitaToUpdate.getGoalCasa() == 0 ) {
					partitaToUpdate.setGoalCasa(partitaRead.getGoalCasa());
				}
				if (partitaToUpdate.getGoalTrasferta() == 0 ) {
					partitaToUpdate.setGoalTrasferta(partitaRead.getGoalTrasferta());
				}

				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, partitaToUpdate.getSquadra1());
				preparedStatement.setString(2, partitaToUpdate.getSquadra2());
				preparedStatement.setInt(3, partitaToUpdate.getData());
				preparedStatement.setInt(4, partitaToUpdate.getOrario());
				preparedStatement.setInt(5, partitaToUpdate.getGoalCasa());
				preparedStatement.setInt(6, partitaToUpdate.getGoalTrasferta());
				preparedStatement.setInt(7, partitaToUpdate.getId());
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
