package controller;

import java.io.IOException;
import java.util.Collections;
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

		System.out.print("Open vhs, dvd, or laserdisc to edit: ");
		String open = in.nextLine();

		if (open.equals("vhs")) {
			Tools.readInFileVHS();
			for (int i = 0; i < Storage.vhs.size(); i++) {
				System.out.println("Read in title: " + Storage.vhs.get(i).getName());
				System.out.println("Read in director: " + Storage.vhs.get(i).getDirector());
				System.out.println("Read in format: " + Storage.vhs.get(i).getFormat());
				//System.out.println("Read in sleeve: " + Storage.vhs.get(i).getSleeveCondition());
				System.out.println("Read in home recording: " + Storage.vhs.get(i).getHomeRecording());
			}
		}

		if (open.equals("dvd") || open.equals("DVD")) {
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
		String homeRecording;
		VHSCollection newVHS;
		DVDCollection newDVD;
		LaserDiscCollection newLD;
		while (test) {
			System.out.print("Title: ");
			title = in.nextLine();
			System.out.print("Director: ");
			director = in.nextLine();
			System.out.print("Format: ");
			format = in.nextLine();
			if (format.equals("vhs")) {
				newVHS = new VHSCollection(title);
				newVHS.setFormat(format);
				newVHS.setDirector(director);
				System.out.print("Sleeve: ");
				sleeve = in.nextLine();
				if (sleeve.equals(""))
					sleeve = " ";
				System.out.print("Home video: ");
				homeRecording = in.nextLine();
				if (homeRecording.equals(""))
					homeRecording = " ";
				//newVHS.setSleeveCondition(sleeve);
				newVHS.setHomeRecording(homeRecording);
				Storage.vhs.add(newVHS);
				Collections.sort(Storage.vhs);
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
