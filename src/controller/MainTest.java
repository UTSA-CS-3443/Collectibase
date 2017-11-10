package controller;

import java.io.IOException;
import java.util.Scanner;

import model.CDCollection;
import model.DVDCollection;
import model.LaserDiscCollection;
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
public class MainTest {

	public static void main(String[] args) throws IOException {
		// Storage storedList = new Storage();
		Scanner in = new Scanner(System.in);

		System.out.print("Open vhs or dvd: ");
		String open = in.nextLine();

		if (open.equals("vhs")) {
			Tools.readInFileVHS();
			for (int i = 0; i < Storage.vhs.size(); i++) {
				System.out.println("Read in title: " + Storage.vhs.get(i).getName());
				System.out.println("Read in format: " + Storage.vhs.get(i).getFormat());
				System.out.println("Read in sleeve: " + Storage.vhs.get(i).getSleeveCondition());
			}
		}

		if(open.equals("dvd") || open.equals("DVD")){
			Tools.readInFileDVD();
			for (int i = 0; i < Storage.dvd.size(); i++) {
				System.out.println("Read in title dvd: " + Storage.dvd.get(i).getName());
				System.out.println("Read in format dvd: " + Storage.dvd.get(i).getFormat());
			}
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
		LaserDiscCollection newLD;
		while (test) {
			System.out.print("Title: ");
			title = in.nextLine();
			System.out.print("Format: ");
			format = in.nextLine();
			if (format.equals("vhs")) {
				newVHS = new VHSCollection(title);
				newVHS.setFormat(format);
				System.out.print("Sleeve: ");
				sleeve = in.nextLine();
				if (sleeve.equals(""))
					sleeve = " ";
				newVHS.setSleeveCondition(sleeve);
				Storage.vhs.add(newVHS);
				Tools.writeFileVHS();
			}

			if (format.equals("dvd")) {
				newDVD = new DVDCollection(title);
				newDVD.setFormat(format);
				Storage.dvd.add(newDVD);
				Tools.writeFileDVD();
			}

			if (format.equals("laserdisc") || format.equals("ld")) {
				newLD = new LaserDiscCollection(title);
				newLD.setFormat(format);
				Storage.ld.add(newLD);
				Tools.writeFileLD();
			}
			
			System.out.print("Exit: ");
			exit = in.nextLine();
			if (exit.equals("yes"))
				test = false;
			in.close();
			System.out.println("Terminated");
		}

	}

}
