package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {

		String[] lines = new String[] { "Bom dia", "Boa tarde", "Boa noite" };

		String path = "C:\\Users\\GFL\\Desktop\\Geral\\JavaNelioAlves\\Projetos\\ws-eclipse\\fileWriter-bufferedWriter\\temp\\ini.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}