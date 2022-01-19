package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			// conexão com o banco de dados
			conn = DB.getConnection();

			st = conn.prepareStatement(
			// comando para atualizar a tabela
			"UPDATE seller " 
			+ "SET BaseSalary = BaseSalary + ? " 
			+ "WHERE " 
			+ "(DepartmentId = ?)");
			// encerra o comando de atualização

			// parametros para atualização
			st.setDouble(1, 200.0);
			st.setInt(2, 2);

			// executa o comando SQL
			int rowsAffected = st.executeUpdate();

			// imprime na tela quantas linhas foram afetadas
			System.out.println("Done! Rows affected: " + rowsAffected);
		
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}