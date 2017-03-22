package Scouting;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.text.NumberFormatter;

public class Team {
	
	//GUI Components
	public JPanel panel;
	
	private JLabel teamNumberLabel;
	private JFormattedTextField teamNumberInput;
	
	private JLabel auto;
	
	private JLabel autoHighLabel;
	private JLabel autoHighInput;
	private JButton autoHighPlusButton;
	private JButton autoHighMinusButton;
	
	private JLabel autoLowLabel;
	private JLabel autoLowInput;
	private JButton autoLowPlusButton;
	private JButton autoLowMinusButton;
	
	private JLabel autoGearLabel;
	private ButtonGroup autoGearGroup;
	private JRadioButton autoNoGearButton;
	private JRadioButton autoLeftButton;
	private JRadioButton autoMiddleButton;
	private JRadioButton autoRightButton;
	
	@SuppressWarnings("unused")
	private int noGearInt = 1;
	private int leftGearInt = 0;
	private int midGearInt = 0;
	private int rightGearInt = 0;
	
	private JLabel autoLineLabel;
	private ButtonGroup autoLineGroup;
	private JRadioButton autoNoLineButton;
	private JRadioButton autoYesLineButton;
	
	@SuppressWarnings("unused")
	private int noLineInt = 1;
	private int yesLineInt = 0;
	
	private JLabel tele;
	
	private JLabel teleHighLabel;
	private JLabel teleHighInput;
	private JButton teleHighPlusButton;
	private JButton teleHighMinusButton;
	
	private JLabel teleLowLabel;
	private JLabel teleLowInput;
	private JButton teleLowPlusButton;
	private JButton teleLowMinusButton;
	
	private JLabel teleGearLabel;
	private JLabel teleGearInput;
	private JButton teleGearPlusButton;
	private JButton teleGearMinusButton;
	
	private JLabel hangLabel;
	private ButtonGroup hangGroup;
	private JRadioButton hangNoButton;
	private JRadioButton hangYesButton;
	
	@SuppressWarnings("unused")
	private int hangNoInt = 1;
	private int hangYesInt = 0;
	
	private JLabel other;
	
	private JLabel ropeLabel;
	private ButtonGroup ropeGroup;
	private JRadioButton ropeNAButton;
	private JRadioButton ropeYesButton;
	private JRadioButton ropeNoButton;
	
	private int ropeNAInt = 1;
	private int ropeNoInt = 0;
	private int ropeYesInt = 0;
	
	private JLabel foulLabel;
	private JLabel foulInput;
	private JButton foulPlusButton;
	private JButton foulMinusButton;
	
	private JLabel techFoulLabel;
	private JLabel techFoulInput;
	private JButton techFoulPlusButton;
	private JButton techFoulMinusButton;
	
	private JButton delButton;
	private JButton addDataButton;
	
	public static int i = 1;
	
	public Team(){
		
		createEverything();
		
		addEverything();
		
		Main.gui.revalidate();
	}
	
	@SuppressWarnings("serial")
	private void createEverything(){
		NumberFormat numForm = NumberFormat.getInstance();
		NumberFormatter teamForm = new NumberFormatter(numForm);
		teamForm.setValueClass(Integer.class);
		teamForm.setMaximum(9999);
		teamForm.setMinimum(0);
		teamForm.setAllowsInvalid(false);
		teamForm.setCommitsOnValidEdit(true);
		NumberFormatter inputForm = new NumberFormatter(numForm);
		inputForm.setValueClass(Integer.class);
		inputForm.setMaximum(999);
		inputForm.setMinimum(0);
		inputForm.setAllowsInvalid(false);
		inputForm.setCommitsOnValidEdit(true);
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		teamNumberLabel = new JLabel("Team Number: ");
		teamNumberInput = new JFormattedTextField(teamForm);
		teamNumberInput.setColumns(4);
		teamNumberInput.setText("0");
		
		auto = new JLabel("AUTO");
		
		autoHighLabel = new JLabel("Fuel Scored High: ");
		autoHighInput = new JLabel(" 0 ");
		autoHighPlusButton = new JButton(new AbstractAction("+"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				String str = autoHighInput.getText().replaceAll(" ", "");
				int amount = Integer.parseInt(str) + 1;
				autoHighInput.setText(" " + amount + " ");
				
				Main.gui.revalidate();
				Main.gui.repaint();
			}
		});
		autoHighMinusButton = new JButton(new AbstractAction("-"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				String str = autoHighInput.getText().replaceAll(" ", "");
				int amount = Integer.parseInt(str) - 1;
				if(amount >= 0){
					autoHighInput.setText(" " + amount + " ");
				}
				else{
					autoHighInput.setText(" 0 ");
				}
				
				Main.gui.revalidate();
				Main.gui.repaint();
			}
		});
		autoLowLabel = new JLabel("Fuel Scored Low: ");
		autoLowInput = new JLabel(" 0 ");
		autoLowPlusButton = new JButton(new AbstractAction("+"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				String str = autoLowInput.getText().replaceAll(" ", "");
				int amount = Integer.parseInt(str) + 1;
				autoLowInput.setText(" " + amount + " ");
				
				Main.gui.revalidate();
				Main.gui.repaint();
			}
		});
		autoLowMinusButton = new JButton(new AbstractAction("-"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				String str = autoLowInput.getText().replaceAll(" ", "");
				int amount = Integer.parseInt(str) - 1;
				if(amount >= 0){
					autoLowInput.setText(" " + amount +" ");
				}
				else{
					autoLowInput.setText(" 0 ");
				}
				Main.gui.revalidate();
				Main.gui.repaint();
			}
		});
		
		autoGearLabel = new JLabel("Gear Scored: ");
		autoGearGroup = new ButtonGroup();
		autoNoGearButton = new JRadioButton("No");
		autoNoGearButton.addActionListener(new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				leftGearInt = 0;
				midGearInt = 0;
				rightGearInt = 0;
				noGearInt = 1;
			}
		});
		autoLeftButton = new JRadioButton("Left");
		autoLeftButton.addActionListener(new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				leftGearInt = 1;
				midGearInt = 0;
				rightGearInt = 0;
				noGearInt = 0;
			}
		});
		autoMiddleButton = new JRadioButton("Middle");
		autoMiddleButton.addActionListener(new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				leftGearInt = 0;
				midGearInt = 1;
				rightGearInt = 0;
				noGearInt = 0;
			}
		});
		autoRightButton = new JRadioButton("Right");
		autoRightButton.addActionListener(new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				leftGearInt = 0;
				midGearInt = 0;
				rightGearInt = 1;
				noGearInt = 0;
			}
		});
		
		autoLineLabel = new JLabel("Cross Line: ");
		autoLineGroup = new ButtonGroup();
		autoNoLineButton = new JRadioButton("No");
		autoNoLineButton.addActionListener(new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				noLineInt = 1;
				yesLineInt = 0;
			}
		});
		autoYesLineButton = new JRadioButton("Yes");
		autoYesLineButton.addActionListener(new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				noLineInt = 0;
				yesLineInt = 1;
			}
		});
		
		tele = new JLabel("TELE");
		
		teleHighLabel = new JLabel("Fuel Scored High: ");
		teleHighInput = new JLabel(" 0 ");
		teleHighPlusButton = new JButton(new AbstractAction("+"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				String str = teleHighInput.getText().replaceAll(" ", "");
				int amount = Integer.parseInt(str) + 1;
				teleHighInput.setText(" " + amount + " ");
				
				Main.gui.revalidate();
				Main.gui.repaint();
			}
		});
		teleHighMinusButton = new JButton(new AbstractAction("-"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				String str = teleHighInput.getText().replaceAll(" ", "");
				int amount = Integer.parseInt(str) - 1;
				if(amount >= 0){
					teleHighInput.setText(" " + amount + " ");
				}
				else{
					teleHighInput.setText(" 0 ");
				}
				
				Main.gui.revalidate();
				Main.gui.repaint();
			}
		});
		teleLowLabel = new JLabel("Fuel Scored Low: ");
		teleLowInput = new JLabel(" 0 ");
		teleLowPlusButton = new JButton(new AbstractAction("+"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				String str = teleLowInput.getText().replaceAll(" ", "");
				int amount = Integer.parseInt(str) + 1;
				teleLowInput.setText(" " + amount + " ");
				
				Main.gui.revalidate();
				Main.gui.repaint();
			}
		});
		teleLowMinusButton = new JButton(new AbstractAction("-"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				String str = teleLowInput.getText().replaceAll(" ", "");
				int amount = Integer.parseInt(str) - 1;
				if(amount >= 0){
					teleLowInput.setText(" " + amount + " ");
				}
				else{
					teleLowInput.setText(" 0 ");
				}
				
				Main.gui.revalidate();
				Main.gui.repaint();
			}
		});
		
		teleGearLabel = new JLabel("Gears Scored: ");
		teleGearInput = new JLabel(" 0 ");
		teleGearPlusButton = new JButton(new AbstractAction("+"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				String str = teleGearInput.getText().replaceAll(" ", "");
				int amount = Integer.parseInt(str) + 1;
				teleGearInput.setText(" " + amount + " ");
				
				Main.gui.revalidate();
				Main.gui.repaint();
			}
		});
		teleGearMinusButton = new JButton(new AbstractAction("-"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				String str = teleGearInput.getText().replaceAll(" ", "");
				int amount = Integer.parseInt(str) - 1;
				if(amount >= 0){
					teleGearInput.setText(" " + amount + " ");
				}
				else{
					teleGearInput.setText(" 0 ");
				}
				
				Main.gui.revalidate();
				Main.gui.repaint();
			}
		});
		
		hangLabel = new JLabel("Hang: ");
		hangGroup = new ButtonGroup();
		hangNoButton = new JRadioButton("No");
		hangNoButton.addActionListener(new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				hangNoInt = 1;
				hangYesInt = 0;
			}
		});
		hangYesButton = new JRadioButton("Yes");
		hangYesButton.addActionListener(new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				hangNoInt = 0;
				hangYesInt = 1;
			}
		});
		
		other = new JLabel("OTHER");
		
		ropeLabel = new JLabel("Pilot Deployed Rope:");
		ropeGroup = new ButtonGroup();
		ropeNAButton = new JRadioButton("N/A");
		ropeNAButton.addActionListener(new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ropeNAInt = 1;
				ropeYesInt = 0;
				ropeNoInt = 0;
			}
		});
		ropeYesButton = new JRadioButton("Yes");
		ropeYesButton.addActionListener(new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ropeNAInt = 0;
				ropeYesInt = 1;
				ropeNoInt = 0;
			}
		});
		ropeNoButton = new JRadioButton("No");
		ropeNoButton.addActionListener(new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ropeNAInt = 0;
				ropeYesInt = 0;
				ropeNoInt = 1;
			}
		});
		
		foulLabel = new JLabel("Fouls: ");
		foulInput = new JLabel(" 0 ");
		foulPlusButton = new JButton(new AbstractAction("+"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				String str = foulInput.getText().replaceAll(" ", "");
				int amount = Integer.parseInt(str) + 1;
				foulInput.setText(" " + amount + " ");
				
				Main.gui.revalidate();
				Main.gui.repaint();
			}
		});
		foulMinusButton = new JButton(new AbstractAction("-"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				String str = foulInput.getText().replaceAll(" ", "");
				int amount = Integer.parseInt(str) - 1;
				
				if(amount >= 0){
					foulInput.setText(" " + amount + " ");
				}
				else{
					foulInput.setText(" 0 ");
				}
				
				Main.gui.revalidate();
				Main.gui.repaint();
			}
		});
		
		techFoulLabel = new JLabel("Tech Fouls: ");
		techFoulInput = new JLabel(" 0 ");
		techFoulPlusButton = new JButton(new AbstractAction("+"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				String str = techFoulInput.getText().replaceAll(" ", "");
				int amount = Integer.parseInt(str) + 1;
				techFoulInput.setText(" " + amount + " ");
				
				Main.gui.revalidate();
				Main.gui.repaint();
			}
		});
		techFoulMinusButton = new JButton(new AbstractAction("-"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				String str = techFoulInput.getText().replaceAll(" ", "");
				int amount = Integer.parseInt(str) - 1;
				
				if(amount >= 0){
					techFoulInput.setText(" " + amount + " ");
				}
				else{
					techFoulInput.setText(" 0 ");
				}
				
				Main.gui.revalidate();
				Main.gui.repaint();
			}
		});
		
		delButton = new JButton(new AbstractAction("DELETE"){
			@Override
			public void actionPerformed(ActionEvent arg0){
				i--;
				
				if(i > 0){
					removePanel();
				}
				else{
					resetEverything();
					i++;
				}
				
				Main.gui.revalidate();
				Main.gui.repaint();
			}
			
		});
		
		addDataButton = new JButton(new AbstractAction("Add Data"){
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				String number = teamNumberInput.getText();
				String autoHigh = autoHighInput.getText();
				String autoLow = autoLowInput.getText();
				String leftGear = leftGearInt + "";
				String midGear = midGearInt + "";
				String rightGear = rightGearInt + "";
				String line = yesLineInt + "";
				String teleHigh = teleHighInput.getText();
				String teleLow = teleLowInput.getText();
				String teleGear = teleGearInput.getText();
				String hang = hangYesInt + "";
				String ropeNA = ropeNAInt + "";
				String ropeYes = ropeYesInt + "";
				String ropeNo = ropeNoInt + "";
				String foul = foulInput.getText();
				String techFoul = techFoulInput.getText();
				
				new AddTeam("1", number, autoHigh, autoLow, leftGear, midGear, rightGear, line, teleHigh, teleLow, teleGear, hang, ropeNA, ropeYes, ropeNo, foul, techFoul);
				
				resetEverything();
				teamNumberInput.setText(number);
				
				Main.gui.revalidate();
				Main.gui.repaint();
			}
		});
	}
	
	private void addEverything(){
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.CENTER;
		
		autoGearGroup.add(autoNoGearButton);
		autoNoGearButton.setSelected(true);
		autoGearGroup.add(autoLeftButton);
		autoGearGroup.add(autoMiddleButton);
		autoGearGroup.add(autoRightButton);
		
		autoLineGroup.add(autoNoLineButton);
		autoNoLineButton.setSelected(true);
		autoLineGroup.add(autoYesLineButton);
		
		hangGroup.add(hangNoButton);
		hangNoButton.setSelected(true);
		hangGroup.add(hangYesButton);
		
		ropeGroup.add(ropeNAButton);
		ropeNAButton.setSelected(true);
		ropeGroup.add(ropeNoButton);
		ropeGroup.add(ropeYesButton);
		
		panel.setLayout(new GridBagLayout());
		
		c.gridx = 0;
		c.gridy = 0;
		panel.add(teamNumberLabel, c);
		
		c.gridx = 1;
		c.gridy = 0;
		panel.add(teamNumberInput, c);
		
		c.gridx = 0;
		c.gridy = 1;
		panel.add(auto, c);
		
		c.gridx = 0;
		c.gridy = 2;
		panel.add(autoHighLabel, c);
		
		c.gridx = 1;
		c.gridy = 2;
		panel.add(autoHighMinusButton, c);
		
		c.gridx = 2;
		c.gridy = 2;
		panel.add(autoHighInput, c);
		
		c.gridx = 3;
		c.gridy = 2;
		panel.add(autoHighPlusButton, c);
		
		c.gridx = 0;
		c.gridy = 3;
		panel.add(autoLowLabel, c);
		
		c.gridx = 1;
		c.gridy = 3;
		panel.add(autoLowMinusButton, c);
		
		c.gridx = 2;
		c.gridy = 3;
		panel.add(autoLowInput, c);
		
		c.gridx = 3;
		c.gridy = 3;
		panel.add(autoLowPlusButton, c);
		
		c.gridx = 0;
		c.gridy = 4;
		panel.add(autoGearLabel, c);
		
		c.gridx = 1;
		c.gridy = 4;
		panel.add(autoNoGearButton, c);
		
		c.gridx = 2;
		c.gridy = 4;
		panel.add(autoLeftButton, c);
		
		c.gridx = 3;
		c.gridy = 4;
		panel.add(autoMiddleButton, c);
		
		c.gridx = 4;
		c.gridy = 4;
		panel.add(autoRightButton, c);
		
		c.gridx = 0;
		c.gridy = 5;
		panel.add(autoLineLabel, c);
		
		c.gridx = 1;
		c.gridy = 5;
		panel.add(autoNoLineButton, c);
		
		c.gridx = 2;
		c.gridy = 5;
		panel.add(autoYesLineButton, c);
		
		c.gridx = 0;
		c.gridy = 6;
		panel.add(tele, c);
		
		c.gridx = 0;
		c.gridy = 7;
		panel.add(teleHighLabel, c);
		
		c.gridx = 1;
		c.gridy = 7;
		panel.add(teleHighMinusButton, c);
		
		c.gridx = 2;
		c.gridy = 7;
		panel.add(teleHighInput, c);
		
		c.gridx = 3;
		c.gridy = 7;
		panel.add(teleHighPlusButton, c);
		
		c.gridx = 0;
		c.gridy = 8;
		panel.add(teleLowLabel, c);
		
		c.gridx = 1;
		c.gridy = 8;
		panel.add(teleLowMinusButton, c);
		
		c.gridx = 2;
		c.gridy = 8;
		panel.add(teleLowInput, c);
		
		c.gridx = 3;
		c.gridy = 8;
		panel.add(teleLowPlusButton, c);
		
		c.gridx = 0;
		c.gridy = 9;
		panel.add(teleGearLabel, c);
		
		c.gridx = 1;
		c.gridy = 9;
		panel.add(teleGearMinusButton, c);

		c.gridx = 2;
		c.gridy = 9;
		panel.add(teleGearInput, c);
		
		c.gridx = 3;
		c.gridy = 9;
		panel.add(teleGearPlusButton, c);
		
		c.gridx = 0;
		c.gridy = 10;
		panel.add(hangLabel, c);
		
		c.gridx = 1;
		c.gridy = 10;
		panel.add(hangNoButton, c);
		
		c.gridx = 2;
		c.gridy = 10;
		panel.add(hangYesButton, c);
		
		c.gridx = 0;
		c.gridy = 11;
		panel.add(other, c);
		
		c.gridx = 0;
		c.gridy = 12;
		panel.add(ropeLabel, c);
		
		c.gridx = 1;
		c.gridy = 12;
		panel.add(ropeNAButton, c);
		
		c.gridx = 2;
		c.gridy = 12;
		panel.add(ropeNoButton, c);
		
		c.gridx = 3;
		c.gridy = 12;
		panel.add(ropeYesButton, c);
		
		c.gridx = 0;
		c.gridy = 13;
		panel.add(foulLabel, c);
		
		c.gridx = 1;
		c.gridy = 13;
		panel.add(foulMinusButton, c);
		
		c.gridx = 2;
		c.gridy = 13;
		panel.add(foulInput, c);
		
		c.gridx = 3;
		c.gridy = 13;
		panel.add(foulPlusButton, c);
		
		c.gridx = 0;
		c.gridy = 14;
		panel.add(techFoulLabel, c);
		
		c.gridx = 1;
		c.gridy = 14;
		panel.add(techFoulMinusButton, c);
		
		c.gridx = 2;
		c.gridy = 14;
		panel.add(techFoulInput, c);
		
		c.gridx = 3;
		c.gridy = 14;
		panel.add(techFoulPlusButton, c);
		
		c.gridx = 0;
		c.gridy = 15;
		panel.add(delButton, c);
		
		c.gridx = 1;
		c.gridy = 15;
		panel.add(addDataButton, c);
		
		Main.gui.teamPanel.add(panel);
	}
	
	private void resetEverything(){
		teamNumberInput.setText("0");
		autoHighInput.setText(" 0 ");
		autoLowInput.setText(" 0 ");
		autoNoGearButton.setSelected(true);
		autoNoLineButton.setSelected(true);
		teleHighInput.setText(" 0 ");
		teleLowInput.setText(" 0 ");
		teleGearInput.setText(" 0 ");
		hangNoButton.setSelected(true);
		ropeNAButton.setSelected(true);
		foulInput.setText(" 0 ");
		techFoulInput.setText(" 0 ");
	}
	
	private void removePanel(){
		Main.gui.teamPanel.remove(panel);
	}
}
