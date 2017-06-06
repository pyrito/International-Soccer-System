/**
 * @(#)InternationalLeague.java
 *
 *
 * @author 
 * @version 1.00 2017/5/12
 */
import java.io.*;
import javax.swing.*;
import java.util.*;

public class InternationalLeague {
        
	static PlayerList plist = new PlayerList();
	static TeamList tlist = new TeamList();
    
    /*
     * This method is the main method with the main menu GUI
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

      JOptionPane optionPane = new JOptionPane();

       boolean done = false;
    
       while(!done)
       {
      	String menu = "1 - Load Data" + "\n" + "2 - Edit Data " + "\n" + "3 - Display " + "\n"+ "4 - Search" + "\n" + "5 - Save Data" + "\n" + "6 - Help" + "\n" + "7 - Quit";
      	String inputValue = JOptionPane.showInputDialog(menu);
      		 int n = Integer.parseInt(inputValue);
	       switch(n)
	       {
	           case 1:  loadFiles(); break;
	           case 2: 	edit();break;
	           case 3:  display(); break;
	           case 4:  search(); break;
	           case 5: 	saveToFile(); break;
	       	   case 6:  help();break;
	       	   case 7: 	done = true; break;
	       }
	       
       }
    }
   
    /*
     * This method creates a prompt for the user to choose the load file that will create the objects for the team and players
     */
   public static void loadFiles() throws IOException{
	   //Scanner in = new Scanner(new File("H:/Users/admin/Documents/workspace/International Soccer System/test.txt"));
	   	JFileChooser chooser = new JFileChooser();
    	chooser.requestFocus();
    	File infile = null;
    	if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
	   	{
	   	  	infile = chooser.getSelectedFile();	
	   	}
	   	Scanner in = new Scanner(infile);
	   int playerCount = in.nextInt();
	   if(!in.hasNext()){
		   JOptionPane.showConfirmDialog(null, "There is nothing in the load file.");
	   }
	   in.nextLine();
	   for(int i = 0; i < playerCount; i++){
		   String position = in.nextLine();
		   System.out.println(position);
		   String name = in.nextLine();
		   String age=  in.nextLine();
		   String number = in.nextLine();
		   double caps = Double.parseDouble(in.nextLine());
		   double goals = Double.parseDouble(in.nextLine());
		   String country = in.nextLine();
		   plist.addPlayer(new Player(name, age, number, caps, position, country, goals));
	   }
	   int teamCount = in.nextInt();
	   in.nextLine();
	   for(int j = 0; j < teamCount; j++){
		   String newCountry = in.nextLine();
		   String coach = in.nextLine();
		   int ranking = Integer.parseInt(in.nextLine());
		   tlist.addTeam(new Team(newCountry, coach, ranking));
	   }
   }
   
    /*
     * This method saves the information in the team and player objects into a text file
     */
   	public static void saveToFile(){
   		String fileName = JOptionPane.showInputDialog("Enter the file name to save to: ");
   			try{
   				//PrintWriter out = new PrintWriter("/Users/admin/Documents/workspace/International Soccer Player System/src/test.txt");
   				PrintWriter out = new PrintWriter(fileName);
   				out.print("");
   				out.print(plist.backup());
   				out.print(tlist.backup());
   				out.close();
   				JOptionPane.showMessageDialog(null, "Information was saved at " + fileName + ".");
   				}
   			catch(IOException exception)
   			{
   			JOptionPane.showMessageDialog(null, "Information could not be saved.");
   			}
   	}
   	
    public static void display(){
    	String[] choices = { "Show all teams and players", "Show all teams in alphabetical", "Show team sorted by goals scored", "Show team sorted by caps", "Show team w/player and age", "Show only player name and goals", "Show player and average goals", "Show partial show based on team" };
   		String input = (String) JOptionPane.showInputDialog(null, "Display Options","International Soccer Player System", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
		String[] i = {"Country" ,"Coach", "Rank", "Position", "Name", "Age", "Team#", "Caps", "Goals", "GPC"};
    	if(input.equals(choices[0])){
    		String mess = String.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s", i[0], i[1], i[2], i[3], i[4], i[5], i[6], i[7], i[8]);
    		/*JOptionPane.showMessageDialog(null, "Country \t\t\t\t Coach \t\t\t\t Rank \t\t\t\t Position \t\t\t\t\t\t\t\t Name \t\t\t\t\t\t\t\t Age \t\t\t\t Team# \t\t\t\t Caps \t\t\t\t Goals"
    				+ "\n========================================================="
    				+ "\n" + tlist.displayAll(plist));*/
    		JOptionPane.showMessageDialog(null, mess + "\n==============================================================================" + "\n" + tlist.displayAll(plist));
    		
    	}
    	else if(input.equals(choices[1])){
    		String mess1 = String.format("%15s %15s %15s", i[0], i[1], i[2]);
    		JOptionPane.showMessageDialog(null, mess1 + "\n==========================" + "\n" + tlist.displayAllTeams());
    	}
    	else if(input.equals(choices[2])){
    		String mess2 = String.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s", i[0], i[1], i[2], i[3], i[4], i[5], i[6], i[7], i[8]);
    		JOptionPane.showMessageDialog(null, mess2 + "\n==============================================================================" + "\n" + tlist.sortGoal(plist));
    	}
    	else if(input.equals(choices[3])){
    		String mess3 = String.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s", i[0], i[1], i[2], i[3], i[4], i[5], i[6], i[7], i[8]);
    		JOptionPane.showMessageDialog(null, mess3 + "\n==============================================================================" + "\n" + tlist.sortCaps(plist));
    	}
    	else if(input.equals(choices[4])){
    		String mess4 = String.format("%15s %15s %15s %15s %15s %15s", i[0], i[1], i[2], i[3], i[4], i[5]);
    		JOptionPane.showMessageDialog(null, mess4 + "\n==============================================================================" + "\n" + tlist.displayByAge(plist));
    		
    	}
    	else if(input.equals(choices[5])){
    		String mess4 = String.format("%15s %15s %15s %15s %15s %15s", i[0], i[1], i[2], i[3], i[4], i[8]);
    		JOptionPane.showMessageDialog(null, mess4 + "\n==============================================================================" + "\n" + tlist.displayByGoals(plist));
    	}
    	else if(input.equals(choices[6])){
    		String mess4 = String.format("%15s %15s %15s %15s %15s %15s", i[0], i[1], i[2], i[3], i[4], i[9]);
    		JOptionPane.showMessageDialog(null, mess4 + "\n==============================================================================" + "\n" + tlist.displayByGoalsPerCap(plist));
    	}
    	else if(input.equals(choices[7]))
    	{
    		String mess7 = String.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s", i[0], i[1], i[2], i[3], i[4], i[5], i[6], i[7], i[8]);
    		partialShow();
    	}
    }
   
    /*
     * This method prompts the interface for the user to search for a player either by name or number
     */
    public static void search(){
    	String[] choices = { "Search by player number", "Search by player name" };
    	String[] i = {"Country" ,"Coach", "Rank", "Position", "Name", "Age", "Team#", "Caps", "Goals", "GPC"};
    	String mess = String.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s", i[0], i[1], i[2], i[3], i[4], i[5], i[6], i[7], i[8]);
   		String input = (String) JOptionPane.showInputDialog(null, "Search Data Menu","International Soccer Player System", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
   		if(input.equals(choices[0])){
   			String[] teams = tlist.findTeam().clone();
			String searchedTeam = (String)JOptionPane.showInputDialog(null, "Search by team", "International Soccer Player System", JOptionPane.QUESTION_MESSAGE, null, teams, teams[0]);
			String[] numbers = plist.searchPlayerNumber(searchedTeam).clone();
			String searchedNumber = (String)JOptionPane.showInputDialog(null, "Search by number", "International Soccer Player System", JOptionPane.QUESTION_MESSAGE, null, numbers, numbers[0]);
			JOptionPane.showMessageDialog(null, mess + "\n==============================================================================" + "\n" + tlist.findTeam(searchedTeam) + plist.findNumber(searchedNumber));
   		}
   		if(input.equals(choices[1])){
   			String[] teams = tlist.findTeam().clone();
			String searchedTeam = (String)JOptionPane.showInputDialog(null, "Search by team", "International Soccer Player System", JOptionPane.QUESTION_MESSAGE, null, teams, teams[0]);
			String[]names = plist.searchPlayerName(searchedTeam).clone();
			String searchedName = (String)JOptionPane.showInputDialog(null, "Search by name", "International Soccer Player System", JOptionPane.QUESTION_MESSAGE, null, names, names[0]);
			JOptionPane.showMessageDialog(null, mess + "\n==============================================================================" + "\n" + tlist.findTeam(searchedTeam) + plist.findName(searchedName));
   		}
	}
    
    /*
     * This method provides the help graphical interface
     */
    public static void help(){
    	JOptionPane.showMessageDialog(null,"This program allows the user to maintain a database that organizes player information for international soccer teams. The"
    			+ "\nmain basis of this program is to ensure that the information of the player is stored properly along with his respective team. The first panel"
    			+ "\nthat the user sees is the main menu that offers different options such as loading from a file, editing data, display, search, save, help, and"
    			+ "\nquit. The edit data menu allows the user to choose multiple options to change the player information or team information. New players and teams"
    			+ "\ncan also be added to the program."
    			+ "\nThe display menu shows all the teams and players in different types of sorts and partial shows. Some of the options sort teams by goals scored,"
    			+ "\ninternational caps, alphabetical, and goals scored."
    			+ "\nThe search menu allows the user to look up players by their numbers and names. "
    			+ "\nTwo objects are needed for the program. "
    			+ "\nThere will be a team object that will have country name, coach name, and ranking. "
    			+ "\nThe other object is the player which will have a name, age, team number, international caps, and goals scored in international career."); 

    }
    
    /*
     * This method provides the options for the partialShow interface (in which the players on a specific team are shown)
     */
    public static void partialShow(){ 
    	String[] teams = tlist.findTeam().clone();
    	String[] i = {"Position", "Name", "Age", "Team#", "Caps", "Goals"};
    	String mess = String.format("%15s %15s %15s %15s %15s %15s", i[0], i[1], i[2], i[3], i[4], i[5]);
		String searchedTeam = (String)JOptionPane.showInputDialog(null, "Search by team", "International Soccer Player System", JOptionPane.QUESTION_MESSAGE, null, teams, teams[0]);
		JOptionPane.showMessageDialog(null, mess + "\n===============================================================" + "\n" + plist.findPlayersOnTeam(searchedTeam));
    }
    
    /*
     * This method provides the prompt for the user to be able to edit the information in the PlayerList and TeamList
     */
    public static void edit(){
    	String[] choices = { "Add new player", "Add new team", "Delete a player", "Delete a team", "Update goals for a player", "Update caps for a player" };
   		String input = (String) JOptionPane.showInputDialog(null, "Edit Data Menu","International Soccer Player System", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
   		
   		JTextField field1 = new JTextField();
		JTextField field2 = new JTextField();
		JTextField field3 = new JTextField();
		JTextField field4 = new JTextField();
		JTextField field5 = new JTextField();
		JTextField field6 = new JTextField();
		JTextField field7 = new JTextField();
		JTextField field8 = new JTextField();
		JTextField field9 = new JTextField();
		JTextField field10 = new JTextField();
		
		Object[] addPlayer = 
    	{
    		"Player Name:", field1,
   			"Age:", field2,
    		"Team Number:", field3,
    		"Caps:", field4,
    		"Goals:", field5,
    		"Position:", field6,
    		"Country:", field7,
    	};
		
		Object[] addTeam = 
		{
			"Country:", field8,
    		"Coach name:", field9,
    		"Ranking:", field10
     	};
     	
   		if(input.equals(choices[0])){
   				int option = JOptionPane.showConfirmDialog(null, addPlayer, "Add a new player", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION)
				{
   		 			String name = field1.getText();
    				String age = field2.getText();
    				String teamNo = field3.getText();
    				double caps = Double.parseDouble(field4.getText());
    				double goals = Double.parseDouble(field5.getText());
    				String pos = field6.getText();
    				String country = field7.getText();	
    				plist.addPlayer(new Player(name, age, teamNo, caps, pos, country, goals));
    				System.out.println(name + " " + age + " " + teamNo + " " + caps);
   				}
    	}
		if(input.equals(choices[1])){
   				int option1 = JOptionPane.showConfirmDialog(null, addTeam, "Add a new team", JOptionPane.OK_CANCEL_OPTION);
				if (option1 == JOptionPane.OK_OPTION)
				{
   					String countryName = field8.getText();
    				String coach = field9.getText();
    				int ranking = Integer.parseInt(field10.getText());	
    				tlist.addTeam(new Team(countryName, coach, ranking));
    				System.out.println(countryName + " " + coach + " " + ranking + " ");
   				}
    	}
		if(input.equals(choices[2])){
			String option2 = JOptionPane.showInputDialog("Name of the player: ");
			if(plist.removePlayer(option2)){
				JOptionPane.showConfirmDialog(null, "Successfully removed player");
			}
			else{
				JOptionPane.showConfirmDialog(null, "Could not find player");
			}
		}
		if(input.equals(choices[3])){
			String option3 = JOptionPane.showInputDialog("Name of the team: ");
			if(tlist.removeTeam(option3)){
				JOptionPane.showConfirmDialog(null, "Successfully removed team");
			}
			else{
				JOptionPane.showConfirmDialog(null, "Could not find player");
			}
		}
		if(input.equals(choices[4])){
			String option4 = JOptionPane.showInputDialog("Name of the player to update goals: ");
			int option5 = Integer.parseInt(JOptionPane.showInputDialog("New goals: "));
			if(plist.updateGoals(option4, option5)){
				JOptionPane.showConfirmDialog(null, "Goals updated");
			}
			else{
				JOptionPane.showConfirmDialog(null, "Player not found");
			}
			
		}
		if(input.equals(choices[5])){
			String option7 = JOptionPane.showInputDialog("Name of player to update caps: ");
			int option8 = Integer.parseInt(JOptionPane.showInputDialog("New caps: "));
			if(plist.updateCaps(option7, option8)){
				JOptionPane.showConfirmDialog(null, "Caps updated");
			}
			else{
				JOptionPane.showConfirmDialog(null, "Player not found");
			}
		}
    }
}
