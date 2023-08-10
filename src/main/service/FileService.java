package main.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.domain.Suspect;

public class FileService {

	public List<Suspect> getSuspectsFromFile() {

		BufferedReader fileReader = null;

		try {
			String line = null;
			List<Suspect> suspects = new ArrayList<>();
			fileReader = new BufferedReader(new FileReader("suspects.txt"));
			String headerLine = fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] lineData = line.split(",");
				Suspect suspect = new Suspect(lineData[0], lineData[1], Boolean.parseBoolean(lineData[2]), lineData[3],
						lineData[4], lineData[5], lineData[6], Integer.parseInt(lineData[7]));
				suspects.add(suspect);
			}
			return suspects;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

}
