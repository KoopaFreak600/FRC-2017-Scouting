package Scouting;

import java.util.HashMap;
import java.util.Map;

public class AddTeam {
	
	public static Map<String, TeamData> teamList = new HashMap<String, TeamData>();
	
	public AddTeam(String games, String number, String autoHigh, String autoLow, String leftGear, String midGear, String rightGear, String line, String teleHigh, String teleLow, String teleGear, 
			String hang, String ropeNA, String ropeYes, String ropeNo, String foul, String techFoul){
		
		insertData(games, number, autoHigh, autoLow, leftGear, midGear, rightGear, line, teleHigh, teleLow, teleGear, hang, ropeNA, ropeYes, ropeNo, foul, techFoul);
	}
	
	public class TeamData{
		String games;
		String number;
		String autoHigh;
		String avgAutoHigh;
		String autoLow;
		String avgAutoLow;
		String leftGear;
		String midGear;
		String rightGear;
		String percAutoGear;
		String line;
		String percLine;
		String teleHigh;
		String avgTeleHigh;
		String teleLow;
		String avgTeleLow;
		String teleGear;
		String avgTeleGear;
		String hang;
		String percHang;
		String ropeNA;
		String ropeYes;
		String ropeNo;
		String percRope;
		String foul;
		String avgFoul;
		String techFoul;
		String avgTechFoul;
	}
	
	private void insertData(String games, String number, String autoHigh, String autoLow, String leftGear, String midGear, String rightGear, String line, String teleHigh, String teleLow, String teleGear, 
			String hang, String ropeNA, String ropeYes, String ropeNo, String foul, String techFoul){
		
		String numKey = number;
		TeamData teamData = new TeamData();
		
		teamData.games = getGames(number, games);
		teamData.number = numKey;
		teamData.autoHigh = getAutoHigh(number, autoHigh);
		teamData.avgAutoHigh = getAvgAutoHigh(teamData.games, teamData.autoHigh);
		teamData.autoLow = getAutoLow(number, autoLow);
		teamData.avgAutoLow = getAvgAutoLow(teamData.games, teamData.autoLow);
		teamData.leftGear = getLeftGear(number, leftGear);
		teamData.midGear = getMidGear(number, midGear);
		teamData.rightGear = getRightGear(number, rightGear);
		teamData.percAutoGear = getPercAutoGear(teamData.games, teamData.leftGear, teamData.midGear, teamData.rightGear);
		teamData.line = getLine(number, line);
		teamData.percLine = getPercLine(teamData.games, teamData.line);
		teamData.teleHigh = getTeleHigh(number, teleHigh);
		teamData.avgTeleHigh = getAvgTeleHigh(teamData.games, teamData.teleHigh);
		teamData.teleLow = getTeleLow(number, teleLow);
		teamData.avgTeleLow = getAvgTeleLow(teamData.games, teamData.teleLow);
		teamData.teleGear = getTeleGear(number, teleGear);
		teamData.avgTeleGear = getAvgTeleGear(teamData.games, teamData.teleGear);
		teamData.hang = getHang(number, hang);
		teamData.percHang = getPercHang(teamData.games, teamData.hang);
		teamData.ropeNA = getRopeNA(number, ropeNA);
		teamData.ropeNo = getRopeNo(number, ropeNo);
		teamData.ropeYes = getRopeYes(number, ropeYes);
		teamData.percRope = getPercRope(teamData.games, teamData.ropeYes, teamData.ropeNA);
		teamData.foul = getFoul(number, foul);
		teamData.avgFoul = getAvgFoul(teamData.games, teamData.foul);
		teamData.techFoul = getTechFoul(number, techFoul);
		teamData.avgTechFoul = getAvgTechFoul(teamData.games, teamData.techFoul);
		
		if(teamList.containsKey(number) == true){		
			teamList.remove(number);
		}
		
		teamList.put(numKey, teamData);
		
		
	}
	
	private String getGames(String number, String games){
		int inserted;
		int initial;
		int fin;
		String output;
		
		if(teamList.containsKey(number) == true){
			inserted = Integer.parseInt(games);
			initial = Integer.parseInt(teamList.get(number).games);
			fin = (int)initial + (int)inserted;
			output = fin + "";
		}
		else{
			inserted = Integer.parseInt(games);
			fin = (int)inserted;
			output = fin + "";
		}
		
		return output;
	}
	
	private String getAutoHigh(String number, String autoHigh){
		int initial;
		int fin;
		String trimmed;
		String output;
		
		trimmed = autoHigh.replaceAll(" ", "");
		
		if(teamList.containsKey(number) == true){
			initial = Integer.parseInt(teamList.get(number).autoHigh);
			fin = initial + Integer.parseInt(trimmed);
			output = fin + "";
		}
		else{
			fin = Integer.parseInt(trimmed);
			output = fin + "";
		}
		
		return output;
	}
	
	private String getAvgAutoHigh(String games, String autoHigh){
		float avg;
		int rounded;
		String output;
		
		avg = (float)(Double.parseDouble(autoHigh)/Double.parseDouble(games));
		rounded = (int)(avg * 1000);
		avg = (float)(rounded/1000);
		output = avg + "";
		
		return output;
	}
	
	private String getAutoLow(String number, String autoLow){
		int initial;
		int fin;
		String trimmed;
		String output;
		
		trimmed = autoLow.replaceAll(" ", "");
		
		if(teamList.containsKey(number) == true){
			initial = Integer.parseInt(teamList.get(number).autoLow);
			fin = initial + Integer.parseInt(trimmed);
			output = fin + "";
		}
		else{
			fin = Integer.parseInt(trimmed);
			output = fin + "";
		}
		
		return output;
	}
	
	private String getAvgAutoLow(String games, String autoLow){
		float avg;
		int rounded;
		String output;
		
		avg = (float)(Double.parseDouble(autoLow)/Double.parseDouble(games));
		rounded = (int)(avg * 1000);
		avg = (float)(rounded/1000);
		output = avg + "";
		
		return output;
	}
	
	private String getLeftGear(String number, String leftGear){
		int initial;
		int fin;
		String output;
		
		if(teamList.containsKey(number) == true){
			initial = Integer.parseInt(teamList.get(number).leftGear);
			fin = initial + Integer.parseInt(leftGear);
			output = fin + "";
		}
		else{
			fin = Integer.parseInt(leftGear);
			output = fin + "";
		}
		
		return output;
	}
	
	private String getMidGear(String number, String midGear){
		int initial;
		int fin;
		String output;
		
		if(teamList.containsKey(number) == true){
			initial = Integer.parseInt(teamList.get(number).midGear);
			fin = initial + Integer.parseInt(midGear);
			output = fin + "";
		}
		else{
			fin = Integer.parseInt(midGear);
			output = fin + "";
		}
		
		return output;
	}
	
	private String getRightGear(String number, String rightGear){
		int initial;
		int fin;
		String output;
		
		if(teamList.containsKey(number) == true){
			initial = Integer.parseInt(teamList.get(number).rightGear);
			fin = initial + Integer.parseInt(rightGear);
			output = fin + "";
		}
		else{
			fin = Integer.parseInt(rightGear);
			output = fin + "";
		}
		
		return output;
	}
	
	private String getPercAutoGear(String games, String leftGear, String midGear, String rightGear){
		float percent;
		double totalGear;
		int rounded;
		String output;
		
		totalGear = Integer.parseInt(leftGear) + Integer.parseInt(midGear) + Integer.parseInt(rightGear);
		percent = (float)(totalGear/Double.parseDouble(games));
		rounded = (int)(percent * 10000);
		percent = (float)(rounded/100);
		output = percent + "%";
		
		return output;
	}
	
	private String getLine(String number, String line){
		int initial;
		int fin;
		String output;
		
		if(teamList.containsKey(number) == true){
			initial = Integer.parseInt(teamList.get(number).line);
			fin = initial + Integer.parseInt(line);
			output = fin + "";
		}
		else{
			fin = Integer.parseInt(line);
			output = fin + "";
		}
		
		return output;
	}
	
	private String getPercLine(String games, String line){
		float percent;
		int rounded;
		String output;
		
		percent = (float)(Double.parseDouble(line)/Double.parseDouble(games));
		rounded = (int)(percent * 10000);
		percent = (float)(rounded/100);
		output = percent + "%";
		
		return output;
	}
	
	private String getTeleHigh(String number, String teleHigh){
		int initial;
		int fin;
		String trimmed;
		String output;
		
		trimmed = teleHigh.replaceAll(" ", "");
		
		if(teamList.containsKey(number) == true){
			initial = Integer.parseInt(teamList.get(number).teleHigh);
			fin = initial + Integer.parseInt(trimmed);
			output = fin + "";
		}
		else{
			fin = Integer.parseInt(trimmed);
			output = fin + "";
		}
		
		return output;
	}
	
	private String getAvgTeleHigh(String games, String teleHigh){
		float avg;
		int rounded;
		String output;
		
		avg = (float)(Double.parseDouble(teleHigh)/Double.parseDouble(games));
		rounded = (int)(avg * 1000);
		avg = (float)(rounded/1000);
		output = avg + "";
		
		return output;
	}
	
	private String getTeleLow(String number, String teleLow){
		int initial;
		int fin;
		String trimmed;
		String output;
		
		trimmed = teleLow.replaceAll(" ", "");
		
		if(teamList.containsKey(number) == true){
			initial = Integer.parseInt(teamList.get(number).teleLow);
			fin = initial + Integer.parseInt(trimmed);
			output = fin + "";
		}
		else{
			fin = Integer.parseInt(trimmed);
			output = fin + "";
		}
		
		return output;
	}
	
	private String getAvgTeleLow(String games, String teleLow){
		float avg;
		int rounded;
		String output;
		
		avg = (float)(Double.parseDouble(teleLow)/Double.parseDouble(games));
		rounded = (int)(avg * 1000);
		avg = (float)(rounded/1000);
		output = avg + "";
		
		return output;
	}
	
	private String getTeleGear(String number, String teleGear){
		int initial;
		int fin;
		String trimmed;
		String output;
		
		trimmed = teleGear.replaceAll(" ", "");
		
		if(teamList.containsKey(number) == true){
			initial = Integer.parseInt(teamList.get(number).teleGear);
			fin = initial + Integer.parseInt(trimmed);
			output = fin + "";
		}
		else{
			fin = Integer.parseInt(trimmed);
			output = fin + "";
		}
		
		return output;
	}
	
	private String getAvgTeleGear(String games, String teleGear){
		float avg;
		int rounded;
		String output;
		
		avg = (float)(Double.parseDouble(teleGear)/Double.parseDouble(games));
		rounded = (int)(avg * 1000);
		avg = (float)(rounded/1000);
		output = avg + "";
		
		return output;
	}
	
	private String getHang(String number, String hang){
		int initial;
		int fin;
		String output;
		
		if(teamList.containsKey(number) == true){
			initial = Integer.parseInt(teamList.get(number).hang);
			fin = initial + Integer.parseInt(hang);
			output = fin + "";
		}
		else{
			fin = Integer.parseInt(hang);
			output = fin + "";
		}
		
		return output;
	}
	
	private String getPercHang(String games, String hang){
		float percent;
		int rounded;
		String output;
		
		percent = (float)(Double.parseDouble(hang)/Double.parseDouble(games));
		rounded = (int)(percent * 10000);
		percent = (float)(rounded/100);
		output = percent + "%";
		
		return output;
	}
	
	private String getRopeYes(String number, String rope){
		int initial;
		int fin;
		String output;
		
		if(teamList.containsKey(number) == true){
			initial = Integer.parseInt(teamList.get(number).ropeYes);
			fin = initial + Integer.parseInt(rope);
			output = fin + "";
		}
		else{
			fin = Integer.parseInt(rope);
			output = fin + "";
		}
		
		return output;
	}
	
	private String getRopeNo(String number, String ropeNo){
		int initial;
		int fin;
		String output;
		
		if(teamList.containsKey(number) == true){
			initial = Integer.parseInt(teamList.get(number).ropeNo);
			fin = initial + Integer.parseInt(ropeNo);
			output = fin + "";
		}
		else{
			fin = Integer.parseInt(ropeNo);
			output = fin + "";
		}
		
		return output;
	}
	
	private String getRopeNA(String number, String ropeNA){
		int initial;
		int fin;
		String output;
		
		if(teamList.containsKey(number) == true){
			initial = Integer.parseInt(teamList.get(number).ropeNA);
			fin = initial + Integer.parseInt(ropeNA);
			output = fin + "";
		}
		else{
			fin = Integer.parseInt(ropeNA);
			output = fin + "";
		}
		
		return output;
	}
	
	private String getPercRope(String games, String ropeYes, String ropeNA){
		float percent;
		int rounded;
		String output;
		
		percent = (float)(Double.parseDouble(ropeYes)/(Double.parseDouble(games) - Double.parseDouble(ropeNA)));
		rounded = (int)(percent * 10000);
		percent = (float)(rounded/100);
		output = percent + "%";
		
		return output;
	}
	
	private String getFoul(String number, String foul){
		int initial;
		int fin;
		String trimmed;
		String output;
		
		trimmed = foul.replaceAll(" ", "");
		
		if(teamList.containsKey(number) == true){
			initial = Integer.parseInt(teamList.get(number).foul);
			fin = initial + Integer.parseInt(trimmed);
			output = fin + "";
		}
		else{
			fin = Integer.parseInt(trimmed);
			output = fin + "";
		}
		
		return output;
	}
	
	private String getAvgFoul(String games, String foul){
		float avg;
		int rounded;
		String output;
		
		avg = (float)(Double.parseDouble(foul)/Double.parseDouble(games));
		rounded = (int)(avg * 1000);
		avg = (float)(rounded/1000);
		output = avg + "";
		
		return output;
	}
	
	private String getTechFoul(String number, String techFoul){
		int initial;
		int fin;
		String trimmed;
		String output;
		
		trimmed = techFoul.replaceAll(" ", "");
		
		if(teamList.containsKey(number) == true){
			initial = Integer.parseInt(teamList.get(number).techFoul);
			fin = initial + Integer.parseInt(trimmed);
			output = fin + "";
		}
		else{
			fin = Integer.parseInt(trimmed);
			output = fin + "";
		}
		
		return output;
	}
	
	private String getAvgTechFoul(String games, String techFoul){
		float avg;
		int rounded;
		String output;
		
		avg = (float)(Double.parseDouble(techFoul)/Double.parseDouble(games));
		rounded = (int)(avg * 1000);
		avg = (float)(rounded/1000);
		output = avg + "";
		
		return output;
	}
	
}
