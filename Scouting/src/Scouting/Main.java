package Scouting;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;

public class Main {

	public static List<Team> classList = new ArrayList<>();
	
	public static Document teamDoc = new Document();
	//public static Element root = new Element("Team_Data");
	//public static Element cleanRoot = new Element("Team_Data");
	
	public static GUI gui;
	public static WriteSpreadsheet writeSpreadsheet = new WriteSpreadsheet();
	public static ReadSpreadsheet readSpreadsheet = new ReadSpreadsheet();
	
	public static void main(String args[]){
		File scoutingFolder = new File("C:/Scouting_Data");
		if(!scoutingFolder.exists()){
			scoutingFolder.mkdir();
		}
		
		//teamDoc.setRootElement(root);
		
		gui = new GUI();
		classList.add(new Team());
		
	}
	
}



