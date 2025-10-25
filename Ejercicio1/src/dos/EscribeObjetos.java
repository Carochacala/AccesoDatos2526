package dos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribeObjetos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nombreFichero="agenda.txt";
		
		Persona a1 =new Persona("Ana","Martínez", "kjeujfrf",25);
		Persona a2 =new Persona("Alicia","Vega","wiekddkh", 32);
		
		try {
			FileOutputStream fs = new FileOutputStream (nombreFichero);
			ObjectOutputStream os=new ObjectOutputStream(fs);
			os.writeObject(a1);
			os.writeObject(a2);
			System.out.println();
			os.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
