package ejercicio6Ampliado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio6Ampliado {

	public static void main(String[] args) {
	try {
		 
		 Class.forName("org.sqlite.JDBC");
		 
		 Connection conexion = DriverManager.getConnection("jdbc:sqlite:src\\ejercicio6Ampliado\\bibliotecaClase.db");
		 Statement sentencia = (Statement) conexion.createStatement();
		 ResultSet resultado = sentencia.executeQuery("select * from LIBRO");
		 
		 
		 System.out.println("         LIBROS          ");
		 while (resultado.next()) { //si devuelve falso no hay más filas
				 
		        System.out.println(resultado.getString("Codigo") + " - " + resultado.getString("Titulo")+ " - " + resultado.getString("Autor"));
			}
		 //conexion.close();
		 
		 Statement sentencia1 = (Statement) conexion.createStatement();
		 ResultSet resultado1 = sentencia1.executeQuery("select * from SOCIO");
		 
		 System.out.println("         SOCIOS          ");
		 while (resultado1.next()) { //si devuelve falso no hay más filas
				
		        System.out.println(resultado1.getString("Nombre") + " " + resultado1.getString("Apelidos")+ " - " + "Teléfono: "+resultado1.getString("Telefono"));
			}
		 
		 
		 Statement sentencia2 = (Statement) conexion.createStatement();
		 ResultSet resultado2 = sentencia2.executeQuery("select * from PRESTAMO");
		 
		 System.out.println("         LISTADO DE PRESTAMOS          ");
		 while (resultado2.next()) { //si devuelve falso no hay más filas
				
		        System.out.println(resultado2.getInt("CodigoLibro")+ " " + resultado2.getInt("CodigoSocio")+ " - " + resultado2.getString("FechaInicioPrestamo"));
			}
		 
		 
		
		 
		 Statement sentencia3= (Statement) conexion.createStatement();
		 ResultSet resultado3 = sentencia3.executeQuery(
				 "select s.Nombre, s.Apelidos, p.FechaInicioPrestamo, p.FechaFinPrestamo, l.Titulo," +
		 		 " l.Autor from PRESTAMO p " +
		 		 "JOIN SOCIO s ON p.CodigoSocio = s.Codigo " +
		 		 "JOIN LIBRO l ON l.Codigo = p.CodigoLibro" 
		 		);	
		  
		 System.out.println("         LISTADO DE PRESTAMOS          ");
		 
		 while (resultado3.next()) { //si devuelve falso no hay más filas
				
		        System.out.println(resultado3.getString("Nombre") + " " +
		                           resultado3.getString("Apelidos")+ " - " +
		                           resultado3.getString("Titulo"));
			}
		 Statement sentencia4= (Statement) conexion.createStatement();
		 ResultSet resultado4 = sentencia4.executeQuery(
				 "SELECT s.Nombre ||' '|| s.Apelidos AS nombre_cliente, p.CodigoLibro,\r\n"
				 + "l.Titulo, p.FechaInicioPrestamo FROM PRESTAMO p\r\n"
				 + "JOIN SOCIO s ON p.CodigoSocio = s.Codigo\r\n"
				 + "JOIN LIBRO l ON l.Codigo = p.CodigoLibro\r\n"
				 + "GROUP BY\r\n"
				 + "nombre_cliente;" 
		 		);	
		  
		 System.out.println("         LISTADO DE PRESTAMOS          ");
		 
		 while (resultado4.next()) { //si devuelve falso no hay más filas
				
		        System.out.println(resultado4.getString("nombre_cliente") + " " +
		                           resultado4.getInt("CodigoLibro")+ " - " +
		                           resultado4.getString("Titulo"));
			}
		 
	
		 
		 conexion.close();
		 
		 
			//siempre cerrar la conexión
			
				 
			
			//select codigo, date('now') from socio; para formatear la fecha
	 }
		
	 catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
  }
}
