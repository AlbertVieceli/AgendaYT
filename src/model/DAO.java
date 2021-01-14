package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	// MÓDULO DE CONEXÃO
	// Parâmetros de conexão
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbagenda";
	// ?useTimezone=true&serverTimezone=UTC
	private String user = "root";
	private String password = "";

	// Método de conexão
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

	/** CRUD CREATE **/
	public void inserirContato(JavaBeans contato) {
		String create = "Insert into contatos (nome,fone,email) value (?,?,?)";
		try {
			// ABRIR CONEXAO
			Connection con = conectar();
			// PREPARAR A QUERY PARA EXECUÇÃO NO BD
			// ClasseModelo = metodo
			PreparedStatement pst = con.prepareStatement(create);
			// substituir as (?) pelas var javabeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			// EXEC A QUERY
			pst.executeUpdate();
			// ENCERRA A CONEXÃO
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// TESTE DE CONEXÃO
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
