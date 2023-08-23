package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BddConexion {

	private static Connection cnn = null;

	private BddConexion() {
		String servidor = "127.0.0.1";
		String database = "gestortalentohumano";
		String usuario = "root";
		String password = "";
		String url = "jdbc:mysql://" + servidor + "/" + database;

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			cnn = DriverManager.getConnection(url, usuario, password);
			System.out.println("Todo bien");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Todo mal");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (cnn == null) {
			new BddConexion();
		}
		return cnn;
	}

	public static void cerrar(ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void cerrar(PreparedStatement pstmt) {

		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void cerrar() {

		try {
			if (cnn != null) {
				cnn.close();
				cnn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}