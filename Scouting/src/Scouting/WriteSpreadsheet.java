package Scouting;

import java.io.File;
import java.io.FileOutputStream;

import org.jdom2.Element;
import org.jdom2.Text;
import org.jdom2.output.XMLOutputter;

public class WriteSpreadsheet {

	public static int teamNumCall = 1;
	public static boolean setRoot = false;
	private static Element root;

	public class addToSpreadsheet{

		public addToSpreadsheet(String keyCall){
			try{
				if(setRoot == false){
					root = new Element("Team_Data");
					Main.teamDoc.setRootElement(root);
					
					setRoot = true;
				}
				
				Element team = new Element("Team");
				Element games = new Element("Games_Submitted");
				Element number = new Element("Number");
				Element autoHigh = new Element("Auto_Fuel_In_High");
				Element avgAutoHigh = new Element("Avg_Auto_Fuel_In_High");
				Element autoLow = new Element("Auto_Fuel_In_Low");
				Element avgAutoLow = new Element("Avg_Auto_Fuel_In_Low");
				Element leftGear = new Element("Auto_Gear_Left");
				Element midGear = new Element("Auto_Gear_Middle");
				Element rightGear = new Element("Auto_Gear_Right");
				Element percAutoGear = new Element("Perc_Games_With_Auto_Gear");
				Element line = new Element("Crossed_Line");
				Element percLine = new Element("Perc_Games_With_Line_Crossed");
				Element teleHigh = new Element("Tele_Fuel_In_High");
				Element avgTeleHigh = new Element("Avg_Tele_Fuel_In_High");
				Element teleLow = new Element("Tele_Fuel_In_Low");
				Element avgTeleLow = new Element("Avg_Tele_Fuel_In_Low");
				Element teleGear = new Element("Tele_Gears");
				Element avgTeleGear = new Element("Avg_Tele_Gears");
				Element hang = new Element("Hang");
				Element percHang = new Element("Perc_Games_With_Hang");
				Element ropeNA = new Element("No_Pilot_In_Airship");
				Element ropeYes = new Element("Pilot_Deployed_Ropes");
				Element ropeNo = new Element("Pilot_Didnt_Deploy_Ropes");
				Element percRope = new Element("Perc_Games_Deployed_Ropes");
				Element foul = new Element("Fouls_Received");
				Element avgFoul = new Element("Avg_Fouls");
				Element techFoul = new Element("Tech_Fouls_Received");
				Element avgTechFoul = new Element("Avg_Tech_Fouls");

				if(AddTeam.teamList.containsKey(keyCall) == true){

					number.addContent(new Text(AddTeam.teamList.get(keyCall).number));
					games.addContent(new Text(AddTeam.teamList.get(keyCall).games));
					autoHigh.addContent(new Text(AddTeam.teamList.get(keyCall).autoHigh));
					avgAutoHigh.addContent(new Text(AddTeam.teamList.get(keyCall).avgAutoHigh));
					autoLow.addContent(new Text(AddTeam.teamList.get(keyCall).autoLow));
					avgAutoLow.addContent(new Text(AddTeam.teamList.get(keyCall).avgAutoLow));
					leftGear.addContent(new Text(AddTeam.teamList.get(keyCall).leftGear));
					midGear.addContent(new Text(AddTeam.teamList.get(keyCall).midGear));
					rightGear.addContent(new Text(AddTeam.teamList.get(keyCall).rightGear));
					percAutoGear.addContent(new Text(AddTeam.teamList.get(keyCall).percAutoGear));
					line.addContent(new Text(AddTeam.teamList.get(keyCall).line));
					percLine.addContent(new Text(AddTeam.teamList.get(keyCall).percLine));
					teleHigh.addContent(new Text(AddTeam.teamList.get(keyCall).teleHigh));
					avgTeleHigh.addContent(new Text(AddTeam.teamList.get(keyCall).avgTeleHigh));
					teleLow.addContent(new Text(AddTeam.teamList.get(keyCall).teleLow));
					avgTeleLow.addContent(new Text(AddTeam.teamList.get(keyCall).avgTeleLow));
					teleGear.addContent(new Text(AddTeam.teamList.get(keyCall).teleGear));
					avgTeleGear.addContent(new Text(AddTeam.teamList.get(keyCall).avgTeleGear));
					hang.addContent(new Text(AddTeam.teamList.get(keyCall).hang));
					percHang.addContent(new Text(AddTeam.teamList.get(keyCall).percHang));
					ropeYes.addContent(new Text(AddTeam.teamList.get(keyCall).ropeYes));
					ropeNo.addContent(new Text(AddTeam.teamList.get(keyCall).ropeNo));
					ropeNA.addContent(new Text(AddTeam.teamList.get(keyCall).ropeNA));
					percRope.addContent(new Text(AddTeam.teamList.get(keyCall).percRope));
					foul.addContent(new Text(AddTeam.teamList.get(keyCall).foul));
					avgFoul.addContent(new Text(AddTeam.teamList.get(keyCall).avgFoul));
					techFoul.addContent(new Text(AddTeam.teamList.get(keyCall).techFoul));
					avgTechFoul.addContent(new Text(AddTeam.teamList.get(keyCall).avgTechFoul));

					team.addContent(number);
					team.addContent(games);
					team.addContent(autoHigh);
					team.addContent(avgAutoHigh);
					team.addContent(autoLow);
					team.addContent(avgAutoLow);
					team.addContent(leftGear);
					team.addContent(midGear);
					team.addContent(rightGear);
					team.addContent(percAutoGear);
					team.addContent(line);
					team.addContent(percLine);
					team.addContent(teleHigh);
					team.addContent(avgTeleHigh);
					team.addContent(teleLow);
					team.addContent(avgTeleLow);
					team.addContent(teleGear);
					team.addContent(avgTeleGear);
					team.addContent(hang);
					team.addContent(percHang);
					team.addContent(ropeYes);
					team.addContent(ropeNo);
					team.addContent(ropeNA);
					team.addContent(percRope);
					team.addContent(foul);
					team.addContent(avgFoul);
					team.addContent(techFoul);
					team.addContent(avgTechFoul);

					root.addContent(team);
				}
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}

	public void write(){

		while(teamNumCall >= 1 && teamNumCall <= 9999){
			String keyCall = teamNumCall + "";

			if(AddTeam.teamList.containsKey(keyCall) == true){
				new addToSpreadsheet(keyCall);
			}

			teamNumCall++;
		}

		if(teamNumCall > 9999){
			teamNumCall = 1;
		}
	}

	public void output(String directory){
		try{
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.output(Main.teamDoc, new FileOutputStream(new File(directory)));
			
			setRoot = false;
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
