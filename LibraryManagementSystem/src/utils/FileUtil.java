package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	public static List<String> readFile(String filename) {
		List<String> lines = new ArrayList<>();
		File file = new File(filename);

		//  Create empty file if missing
		try {
			if (!file.exists()) {
				File parent = file.getParentFile();
				if (parent != null && !parent.exists()) {
					parent.mkdirs(); // Create folder
				}
				file.createNewFile();
			}

			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null)
				lines.add(line);
			br.close();
		} catch (IOException e) {
			System.out.println("File read error: " + e.getMessage());
		}

		return lines;
	}

	public static void writeFile(String filename, List<String> lines) {
		try {
			File file = new File(filename);
			// Ensure parent folder exists
			File parent = file.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs(); //  create the folder
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
				for (String line : lines) {
					bw.write(line);
					bw.newLine();
				}
			}
		} catch (IOException e) {
			System.out.println("File write error: " + e.getMessage());
		}
	}

}
