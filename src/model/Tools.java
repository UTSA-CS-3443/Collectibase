package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Different tools used for Collectibase. Writing to file, reading form file,
 * and various sorting methods
 * 
 * Updated 11/7/17
 * 
 * @author Travis
 *
 */
public class Tools {
	/**
	 * writeFile() will write information to a specific .txt depending on the type of collection.
	 * Currently the write file only will write vhs.txt and dvd.txt with minimal information such as 
	 * 		- movie title
	 * 		- media format
	 * 		- sleeve condition (for vhs only)
	 * 
	 * TODO: add the information for the other variables to the VHSCollection and DVDCollection
	 * TODO: add the logic/algorithm for each type of collection.
	 * 
	 */
	public static void writeFile() {
		System.out.println("\nWrite File\n");

		try (PrintWriter out = new PrintWriter("vhs.txt")) {
			if (Storage.vhs.size() > 0) {
				System.out.println("Made it to VHS write");
				for (int i = 0; i < Storage.vhs.size(); i++) {
					out.printf("%s,%s,%s", Storage.vhs.get(i).getName(), Storage.vhs.get(i).getFormat().trim(),
							Storage.vhs.get(i).getSleeveCondition());
					out.println("");
				}
				out.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try (PrintWriter out = new PrintWriter("dvd.txt")) {
			if (Storage.dvd.size() > 0) {
				System.out.println("Made it to dvd write");
				for (int i = 0; i < Storage.dvd.size(); i++) {
					out.printf("%s,%s", Storage.dvd.get(i).getName(), Storage.dvd.get(i).getFormat().trim());
					out.println("");
				}
				out.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * readInFile() will write information to a specific .txt depending on the type of collection.
	 * Currently the teadInFile will only read vhs.txt and dvd.txt with minimal information such as 
	 * 		- movie title
	 * 		- media format
	 * 		- sleeve condition (for vhs only)
	 * 
	 * TODO: add the information for the other variables to the VHSCollection and DVDCollection
	 * TODO: add the logic/algorithm for each type of collection.
	 * 
	 */
	public static void readInFile() {
		System.out.println("Tools.readInFile()");
		Scanner in = null;
		VHSCollection vhs;
		DVDCollection dvd;
		String format, title, sleeve;

		// write for each file, one line per, use nextLine()
		try {
			in = new Scanner(new File("vhs.txt"));
			while (in.hasNextLine()) {
				String line = in.nextLine();
				String[] tokens = line.split(",");
				title = tokens[0];
				format = tokens[1];
				sleeve = tokens[2];
				vhs = new VHSCollection(title);
				vhs.setFormat(format);
				vhs.setSleeveCondition(sleeve);
				Storage.vhs.add(vhs);
			}
			in.close();
		} catch (FileNotFoundException exception) {
			throw new RuntimeException("failed to open vhs.txt");
		}

		try {
			in = new Scanner(new File("dvd.txt"));
			while (in.hasNextLine()) {
				String line = in.nextLine();
				String[] tokens = line.split(",");
				title = tokens[0];
				format = tokens[1];
				dvd = new DVDCollection(title);
				dvd.setFormat(format);
				Storage.dvd.add(dvd);
			}
			in.close();
		} catch (FileNotFoundException exception) {
			throw new RuntimeException("failed to open dvd.txt");
		}
	}
}
