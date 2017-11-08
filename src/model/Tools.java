package model;

import java.io.File;
import java.io.FileNotFoundException;
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

	public static void WriteFile() throws FileNotFoundException {
		System.out.println("\nWrite File\n");
		
		try (PrintWriter out = new PrintWriter("vhs.txt")) {
		if (Storage.vhs.size() > 0) {
				System.out.println("Made it to VHS write");
				for (int i = 0; i < Storage.vhs.size(); i++) {
					out.printf("%s, %s", Storage.vhs.get(i).getName(), Storage.vhs.get(i).getFormat());
					out.println("");
				}
				//out.close();
			} 
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	public static void readInFile() {
		System.out.println("Tools.readInFile()");
		Scanner in = null;
		VHSCollection vhs;
		String format;
		String title;
		// write for each file, one line per, use nextLine()
		try {
			in = new Scanner(new File("vhs.txt"));
			while(in.hasNextLine()) {
				String line = in.nextLine();
				String[] tokens = line.split(",");
				title = tokens[0];
				format = tokens[1];
				vhs = new VHSCollection(title);
				vhs.setFormat(format);
				Storage.vhs.add(vhs);
			}
			in.close();
		} catch (FileNotFoundException exception) {
			throw new RuntimeException("failed to open Master.txt");
		}
	}
}
