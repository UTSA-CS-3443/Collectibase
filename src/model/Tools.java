package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

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
					out.println("format " + Storage.vhs.get(i).getFormat());
					out.println("title " + Storage.vhs.get(i).getName());
					// out.println(Storage.vhs.get(i).getSleeveCondition());
				}
			}

			if (Storage.dvd.size() > 0) {

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void readInFile() throws IOException {
		System.out.println("Tools.readInFile()");
		String fileName = "Master.txt";
		String line = null;

		String format;
		String title;
		VHSCollection newVHS;
		DVDCollection newDVD;

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				// format can be used for movies and music
				
				if (line.contains("format")) {
					String[] tokens = line.split(" ");
					format = tokens[1];

					if (format.equals("vhs")) {
						for (int i = 0; i < Storage.vhs.size(); i++) {
							Storage.vhs.get(i).setFormat(format);
						}
					}
				}
				

				if (line.contains("title")) {
					String[] tokens = line.split(" ");
					if (tokens.length > 2) {
						title = "";
						for (int i = 1; i < tokens.length; i++)
							title += tokens[i] + " ";
					} else {
						title = tokens[1];
					}
					newVHS = new VHSCollection(title);
					Storage.vhs.add(newVHS);
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
