package Scouting;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;

public class Main {

	public static List<Team> classList = new ArrayList<>();
	
	public static Document teamDoc = new Document();
	
	public static GUI gui;
	public static WriteSpreadsheet writeSpreadsheet = new WriteSpreadsheet();
	public static ReadSpreadsheet readSpreadsheet = new ReadSpreadsheet();
	
	public static void main(String args[]){
		File scoutingFolder = new File("C:/Scouting_Data");
		if(!scoutingFolder.exists()){
			scoutingFolder.mkdir();
		}
		
		gui = new GUI();
		classList.add(new Team());
		
	}
	
}



