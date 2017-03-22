package Scouting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener{
	private JPanel topPanel;
	public JPanel teamPanel;
	private JPanel bottomPanel;
	
	private JScrollPane teamScroll;
	
	private JButton addButton;
	private JButton insertButton;
	private JButton writeButton;
	
	final JFileChooser fc = new JFileChooser();
	final FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
	
	private String loadDirectory = null;
	private String saveDirectory = "C:/";
	
	private static int repeatedDoc = 1;
	
	public GUI(){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		topPanel = new JPanel();
		teamPanel = new JPanel();
		bottomPanel = new JPanel();
		
		teamScroll = new JScrollPane(teamPanel);
		
		addButton = new JButton(new AbstractAction("ADD TEAM"){

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0){
				Main.classList.add(new Team());
				Team.i++;
			}
		});
		
		writeButton = new JButton(new AbstractAction("Write Spreadsheet"){
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				
				fc.setCurrentDirectory(new File("C:/Scouting_Data"));
				fc.setFileFilter(fileFilter);
				
				int fileRes = fc.showOpenDialog(null);
				
				if(fileRes == JFileChooser.APPROVE_OPTION){
					File selectedFile = fc.getSelectedFile();
					saveDirectory = selectedFile.getAbsolutePath();
					//File checkFile = new File(saveDirectory);
					saveDirectory = saveDirectory.replaceAll(".xml", "");
					saveDirectory = saveDirectory + ".xml";
					
					//if(checkFile.exists() == true){
					//	saveDirectory = saveDirectory + "(" + repeatedDoc + ")";
					//	repeatedDoc++;
					//}
					
					//saveDirectory = saveDirectory.replaceAll(".xml", "");
					//saveDirectory = saveDirectory + ".xml";
					
					Main.writeSpreadsheet.write();
					Main.writeSpreadsheet.output(saveDirectory);
				}
			}
		});
		
		insertButton = new JButton(new AbstractAction("Insert Spreadsheet"){
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				
				fc.setCurrentDirectory(new File("C:/Scouting_Data"));
				fc.setFileFilter(fileFilter);
				
				int fileRes = fc.showOpenDialog(null);
				
				if(fileRes == JFileChooser.APPROVE_OPTION){
					File selectedFile = fc.getSelectedFile();
					loadDirectory = selectedFile.getAbsolutePath();
					loadDirectory = saveDirectory.replaceAll(".xml", "");
					loadDirectory = saveDirectory + ".xml";
					
					if(loadDirectory != null){
						Main.readSpreadsheet.read(loadDirectory);
					}
				}
			}
		});
		
		setLayout(new BorderLayout());
		setTitle("FRC 2017 STEAMWORKS Scouting");
		setSize(1200, 900);
		setVisible(true);
		
		topPanel.setBackground(Color.YELLOW);
		add(topPanel, BorderLayout.PAGE_START);
		
		teamPanel.setBackground(Color.YELLOW);
		teamPanel.setLayout(new GridLayout(0, 3));
		add(teamScroll, BorderLayout.CENTER);
		
		bottomPanel.setBackground(Color.YELLOW);
		add(bottomPanel, BorderLayout.PAGE_END);
		
		topPanel.add(addButton);
		bottomPanel.add(insertButton);
		bottomPanel.add(writeButton);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
