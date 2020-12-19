package model;

import java.sql.*;

public class DAO {
	//MÓDULO DE CONEXÃO
	//Parâmetros de conexão
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbagenda";
	//?useTimezone=true&serverTimezone=UTC
	private String user = "root";
	private String password = "";
	
	//Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//TESTE DE CONEXÃO
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch  (Exception e) {
			System.out.println(e);
		}
	}
	
}
