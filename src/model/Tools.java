package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

import controller.VHSController;

/**
 * Different tools used for Collectibase. Writing to file, reading form file,
 * and various sorting methods
 * 
 * Updated 11/7/17
 * 
 * @author jesusnieto
 * @author Travis
 *
 *
 */
public class Tools {
	
	public void writeVHSFile() throws Exception {
		Writer writer = null;
		try {
			File file = new File("vhs.txt");
			writer = new BufferedWriter(new FileWriter(file));
			for (VHSCollection vhs : Storage.allVHS) {
				String text = vhs.getTitle() + "," + vhs.getGenre() + "," + vhs.getFormat() + "," + vhs.getYear() + ","
						+ vhs.getDirector() + "," + vhs.getSpecialEdition() + "," + vhs.getHomeRecording() + ","
						+ vhs.getMultiProgram() + "," + vhs.getMultiTape() + "," + vhs.getSleeveType() + "\n";
				writer.write(text);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			writer.flush();
			writer.close();

		}
	}
	
	
	
}
