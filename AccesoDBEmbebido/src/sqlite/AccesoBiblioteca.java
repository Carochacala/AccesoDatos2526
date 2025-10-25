package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBiblioteca {
	
	public static void main(String[] args) {
	
	try {
		
		//Crear instancia del JDBC driver
	Class.forName("org.sqlite.JDBC");
	
	// 2.Especificar la url de la base de datos y 3.establecer conexión usando el driver que crea el objeto connection
	Connection conexion = DriverManager.getConnection("jdbc:sqlite:src\\sqlite\\bibliotecaClase.db");
	
	//4. Creo un objeto Statement, usando Connection
	Statement sentencia = (Statement) conexion.createStatement();
	
	//Armo el postulado SQL y enviarlo a ejecución usando el Statement
	ResultSet resultado = sentencia.executeQuery("select * from SOCIO");
	
	//recorrer el reslutado
	while (resultado.next()) { //si devuelve falso no hay más filas
		
        System.out.println(resultado.getString("Nombre") + "-" + resultado.getString("Apelidos"));
	}
	//siempre cerrar la conexión
	conexion.close();
	
	}
	
	catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}

  }
}
