package br.com.loginapp;

//1. Importando bibliotecas
import java.sql.Connection; // Representa uma conexão aberta
import java.sql.DriverManager; // criar conexões a partir da url
import java.sql.SQLException; // Trata exceções de operações SQL

//2. Criando Classe pública - Centraliza a lógica de abrir a conexão
public class Conexao {

	private static final String URL = "jdbc:mysql://localhost:3307/sistema_login";
	private static final String USUARIO = "root";
	private static final String SENHA = "senac"; // ajuste se tiver senha no root

	public static Connection conectar() {
		Connection conexao = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Conectado ao banco de dados!");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver JDBC não encontrado: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Erro ao conectar: " + e.getMessage());
		}
		return conexao;
	}
}