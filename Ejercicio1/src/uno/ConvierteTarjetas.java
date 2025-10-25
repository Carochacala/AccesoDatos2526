package uno;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ConvierteTarjetas {

	public static void main(String[] args) {
		
		File ficheroLectura = new File ("datos.txt");
		File ficheroEscritura = new File("escribe.txt");
		
		try {
			
			//FileReader lector = new FileReader(ficheroTarjetas);
			BufferedReader cestaTemporal = new BufferedReader(new FileReader(ficheroLectura)); // ahora voy a leer utilizando un buffer
			
			FileWriter escritor=new FileWriter(ficheroEscritura,true); 
			BufferedWriter cestaEscritura = new BufferedWriter(escritor); //escribo con el buffer
			
			String linea = cestaTemporal.readLine();
			String lineaTratada="";
			
			while (linea != null) {	
		    //interpretar línea
				String[] datos = linea.split(","); 
				
				lineaTratada = "Nombre: "+datos[0]+"\n" 
				+"Apellidos: " + datos[1] + "\n"
				+"Fecha nacimiento: " + datos[2] + "\n"
				+"Teléfono: " + datos[3] + "\n\n";
				
				cestaEscritura.write(lineaTratada);
	                
	             linea = cestaTemporal.readLine();
	             System.out.println(lineaTratada);
				}
				
			cestaEscritura.newLine();
            
            cestaEscritura.close();
            cestaTemporal.close();
            
			    				
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("No se encontro el archivo");
		}
		
}
	}


