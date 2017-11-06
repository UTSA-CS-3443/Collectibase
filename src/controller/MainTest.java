package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import model.CDCollection;
import model.DVDCollection;
import model.Storage;
import model.VHSCollection;
import model.Tools;

/**
 * non-GUI, used to test the parent/child classes to make sure inheritance is
 * correct, as well as adding particular collections to their respective
 * ArrayList.
 * 
 * @author Travis
 *
 */
//addes comment for reasons
public class MainTest {

	public static void main(String[] args) throws IOException {
		// Storage storedList = new Storage();
		Scanner in = new Scanner(System.in);
		
		Tools.readInFile();
		for (int i = 0; i < Storage.vhs.size(); i++) {
			System.out.println("Read in title: " + Storage.vhs.get(i).getName());
			System.out.println("Read in format: " + Storage.vhs.get(i).getFormat());
			// System.out.println("Read in sleeve: " +
			// Storage.vhs.get(i).getSleeveCondition());
		}
		
		  for (int i = 0; i < Storage.dvd.size(); i++) {
		  System.out.println("Read in title dvd: " + Storage.dvd.get(i).getName());
		  System.out.println("Read in format dvd: " + Storage.dvd.get(i).getFormat());
		  }
		 

		boolean test = true;
		String title;
		String director;
		String year;
		String format;
		String sleeve;
		String exit;
		VHSCollection newVHS;
		DVDCollection newDVD;
		while (test) {
			System.out.print("Title: ");
			title = in.nextLine();
			System.out.print("Director: ");
			director = in.nextLine();
			System.out.print("Year: ");
			year = in.nextLine();
			System.out.print("Format: ");
			format = in.nextLine();
			System.out.print("Sleeve: ");
			sleeve = in.nextLine();
			System.out.print("Exit: ");
			exit = in.nextLine();
			if (exit.equals("yes"))
				test = false;
			if (format.equals("vhs")) {
				newVHS = new VHSCollection(title);
				newVHS.setFormat(format);
				newVHS.setSleeveCondition(sleeve);
				Storage.vhs.add(newVHS);
			}
			
			if(format.equals("dvd")) {
				newDVD = new DVDCollection(title);
				newDVD.setFormat(format);
				Storage.dvd.add(newDVD);	
			}
			Tools.WriteFile();
		}

		// VHSCollection newVHS = new VHSCollection(title);
		// Storage.vhs.add(newVHS);
		// Storage.vhs.get(0).setSleeveCondition(sleeve);

		// Tools.WriteFile();
		// in.close();

	}

}
