package Scouting;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadSpreadsheet {
	
	public void read(String directory){
		try{
			File xmlFile = new File(directory);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document inputDoc = dBuilder.parse(xmlFile);
			
			inputDoc.getDocumentElement().normalize();
			NodeList nodeList = inputDoc.getElementsByTagName("Team");
			
			for(int dataCall = 0; dataCall < nodeList.getLength(); dataCall++){
				Node node = nodeList.item(dataCall);
				
				if(node.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element)node;
					
					String games = element.getElementsByTagName("Games_Submitted").item(0).getTextContent();
					String number = element.getElementsByTagName("Number").item(0).getTextContent();
					String autoHigh = element.getElementsByTagName("Auto_Fuel_In_High").item(0).getTextContent();
					String autoLow = element.getElementsByTagName("Auto_Fuel_In_Low").item(0).getTextContent();
					String leftGear = element.getElementsByTagName("Auto_Gear_Left").item(0).getTextContent();
					String midGear = element.getElementsByTagName("Auto_Gear_Middle").item(0).getTextContent();
					String rightGear = element.getElementsByTagName("Auto_Gear_Right").item(0).getTextContent();
					String line = element.getElementsByTagName("Crossed_Line").item(0).getTextContent();
					String teleHigh = element.getElementsByTagName("Tele_Fuel_In_High").item(0).getTextContent();
					String teleLow = element.getElementsByTagName("Tele_Fuel_In_Low").item(0).getTextContent();
					String teleGear = element.getElementsByTagName("Tele_Gears").item(0).getTextContent();
					String hang = element.getElementsByTagName("Hang").item(0).getTextContent();
					String ropeNA = element.getElementsByTagName("No_Pilot_In_Airship").item(0).getTextContent();
					String ropeYes = element.getElementsByTagName("Pilot_Deployed_Ropes").item(0).getTextContent();
					String ropeNo = element.getElementsByTagName("Pilot_Didnt_Deploy_Ropes").item(0).getTextContent();
					String foul = element.getElementsByTagName("Fouls_Received").item(0).getTextContent();
					String techFoul = element.getElementsByTagName("Tech_Fouls_Received").item(0).getTextContent();
					
					new AddTeam(games, number, autoHigh, autoLow, leftGear, midGear, rightGear, line, teleHigh, teleLow, teleGear, hang, ropeNA, ropeYes, ropeNo, foul, techFoul);
				}
			}
			
		}catch(Exception e){
			//System.out.println(e);
		}
	}
	
}
