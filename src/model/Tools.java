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

	public static void WriteFile() {
		System.out.println("\nWrite File\n");

		try (PrintWriter out = new PrintWriter("Master.txt")) {
			if (Storage.vhs.size() > 0) {
				out.println("VHS");
				for (int i = 0; i < Storage.vhs.size(); i++) {
					out.println("vhs title " + Storage.vhs.get(i).getName());
					out.println("vhs format " + Storage.vhs.get(i).getFormat());
					out.println("vhs sleeve " + Storage.vhs.get(i).getSleeveCondition());
				}
			}

			if (Storage.dvd.size() > 0) {
				out.println("DVD");
				for (int i = 0; i < Storage.dvd.size(); i++) {
					out.println("dvd title " + Storage.dvd.get(i).getName());
					out.println("dvd format " + Storage.dvd.get(i).getFormat());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void readInFile() {
		System.out.println("Tools.readInFile()");
		Scanner in = null;
		VHSCollection vhs;
		DVDCollection dvd;
		String title = null;
		String format;
		try {
			in = new Scanner(new File("Master.txt"));
		} catch (FileNotFoundException exception) {
			throw new RuntimeException("failed to open Master.txt");
		}

		while (in.hasNext()) {
			if (in.next().equals("vhs")) {
				System.out.println("This is " + in);
				if (in.next().equals("title")) {
					title = in.nextLine();
					vhs = new VHSCollection(title);
					Storage.vhs.add(vhs);
				}

				if (in.next().equals("vhs") && in.next().equals("format")) {
					format = in.nextLine();
					for (int i = 0; i < Storage.vhs.size(); i++) {
						Storage.vhs.get(i).setFormat(format);
					}
				}

			} else if(in.next().equals("dvd")) {
				if (in.next().equals("title")) {
					title = in.nextLine();
					dvd = new DVDCollection(title);
					Storage.dvd.add(dvd);
				}

				if ( in.next().equals("dvd") && in.next().equals("format")) {
					format = in.nextLine();
					Storage.dvd.get(0).setFormat(format);
				}
			}

		}
		in.close();
	}
}
