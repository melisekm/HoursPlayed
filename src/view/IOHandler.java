package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import model.DateControl;

public class IOHandler {
	public DateControl initialize() {
		try {
			System.out.println("Deserializujem data...");
			FileInputStream fileInputStream = new FileInputStream("data\\data.dat");

			if (fileInputStream.available() == 0) { // skontroluje, ci nie je prazdny
				fileInputStream.close();
				return this.createNewObj();
			}

			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);// nacita objekty
			DateControl data = (DateControl) objectInputStream.readObject();
			System.out.println("Hotovo");
			objectInputStream.close();
			return data;

		} catch (IOException | ClassNotFoundException e) {
			System.err.println("ERROR");
			e.printStackTrace();
		}

		return null;
	}

	public void saveObj(DateControl data) {
		System.out.println("Prebieha ukladanie, prosim nevypinajte program");
		try {
			FileOutputStream file = new FileOutputStream("data\\data.dat");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(data);
			out.close();
			System.out.println("Ukladanie uspesne ukoncene");
		} catch (IOException e) {
			System.err.println("Chyba pri ukladani");
			e.printStackTrace();
		}
	}

	public DateControl createNewObj() {
		return new DateControl();
	}
	
	public void clearContent() {
		try {
			FileOutputStream file = new FileOutputStream("data\\data.dat");
			PrintWriter writer = new PrintWriter(file);
			writer.print("");
			writer.close();
		}catch(Exception e) {
			System.err.println("Chyba pri cisteni suboru");
			e.printStackTrace();
		}
	}
}
