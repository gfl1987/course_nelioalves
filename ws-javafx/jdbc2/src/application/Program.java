package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {

		// variável de conexão
		Connection conn = null;

		// variável que prepara a consulta sql
		Statement st = null;

		// variável que guarda o resultado da consulta sql
		ResultSet rs = null;

		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from department");

			// while = enquanto 
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}