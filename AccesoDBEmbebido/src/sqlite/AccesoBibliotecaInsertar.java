package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBibliotecaInsertar {
	
	public static void main(String[] args) {
	
	try {
		
		//Crear instancia del JDBC driver
	Class.forName("org.sqlite.JDBC");
	
	// 2.Especificar la url de la base de datos y 3.establecer conexión usando el driver que crea el objeto connection
	Connection conexion = DriverManager.getConnection("jdbc:sqlite:src\\sqlite\\bibliotecaClase.db");
	
	//4. Creo un objeto Statement, usando Connection
	Statement sentencia = (Statement) conexion.createStatement();
	
	//Armo el postulado SQL y enviarlo a ejecución usando el Statement
	//Armo el postulado SQL y enviarlo a ejecución usando el Statement
		int insertarFilas = sentencia.executeUpdate(
				"INSERT INTO PRESTAMO (CodigoLibro, CodigoSocio, FechaInicioPrestamo, FechaFinPrestamo)" +
				"VALUES (1,3,\"2025-10-17\",\"2025-11-03\")");
		
	if(insertarFilas > 0) 
		System.out.println(insertarFilas + "modificados");
	else 
		System.out.println();
	
	//recorrer el reslutado
	
		System.out.println("filas insertadas "+ insertarFilas);
		
	//siempre cerrar la conexión
	conexion.close();
	
	}
	
	catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}

  }
}
