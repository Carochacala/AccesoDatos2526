package dos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerObjetos {

	public static void main(String[] args) {
		String nombreFichero="agenda.dat";
		
		
		try {
		FileInputStream ficheroAgenda = new FileInputStream (nombreFichero);
		ObjectInputStream lector = new ObjectInputStream (ficheroAgenda);
		
		Persona p =(Persona)lector.readObject();
		
		System.out.println(p);
		
		p.setPassword("kjeujfrf");
		System.out.println(p);
		
			
		}
		catch(IOException e) {
			System.err.println("No ha encontrado el fichero o está corrupto");
		}
		catch (ClassNotFoundException e) {
			
		}

	}

}
