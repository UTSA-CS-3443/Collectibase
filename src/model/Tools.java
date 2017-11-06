package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * \ Different tools used for Collectibase. Writing to file, reading form file,
 * and various sorting methods
 * 
 * @author Travis
 *
 */
public class Tools {

	public static void WriteFile() {
		System.out.println("\nWrite File\n");

		try (PrintWriter out = new PrintWriter("Master.txt")) {
			if (Storage.vhs.size() > 0) {
				out.println("VHS");
				for (int i = 0; i < Storage.vhs.size(); i++) {
					out.println(Storage.vhs.get(i).getName());
					out.println(Storage.vhs.get(i).getSleeveCondition());
				}
			}

			if (Storage.dvd.size() > 0) {

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void readInFile() throws IOException {
		System.out.println("Read in File");
		// Scanner in = null;
		String fileName = "Master.txt";
		String line = null;

		String format;
		String title;

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains("start")) {
					VHSCollection newVHS = new VHSCollection("");
					Storage.vhs.add(newVHS);
				}

				if (line.contains("format")) {
					String[] tokens = line.split(" ");
					format = tokens[1];
					if (format.equals("vhs")) {
						for(int i = 0; i < Storage.vhs.size(); i++) {
							Storage.vhs.get(i).setFormat(format);
						}
					}
						
				}

				if (line.contains("title")) {
					String[] tokens = line.split(" ");
					title = tokens[1];
					Storage.vhs.get(0).setName(title);
				}

			}

			bufferedReader.close();
		} catch (FileNotFoundException exception) {
			System.err.println("Failed to open Master.txt");
			System.exit(1);
		}

		// in.close();
	}
}
