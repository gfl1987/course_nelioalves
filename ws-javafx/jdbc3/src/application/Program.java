package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {

		// formatação da data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			//conexão com o banco de dados
			conn = DB.getConnection();

			// Primeiro exemplo:
			// Inserindo um vendedor na tabela SELLER
			st = conn.prepareStatement(
					"INSERT INTO seller " 
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES " + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, "Guilherme Fonseca");
			st.setString(2, "guilherme.leite1987@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("15/11/1987").getTime()));
			st.setDouble(4, 7000.0);
			st.setInt(5, 4);

			// Segundo exemplo:
			// st = conn.prepareStatement(
			// "insert into department (Name) values ('D1'),('D2')",
			// Statement.RETURN_GENERATED_KEYS);

			// executeUpdate serve para atualizar e tabela executando a operação
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id: " + id);
				}
			} else {
				System.out.println("No rows affected!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ParseException e) {
			e.printStackTrace();
			
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}