/**
 * @(#)PlayerList.java
 *
 *
 * @author Karthik Velayutham
 * @version 1.00 2017/5/12
 */

import java.util.*;

public class PlayerList {
	
	ArrayList<Player> plist;
	
	/*
	 * Default constructor for the PlayerList class
	 */
    public PlayerList() {
    	plist = new ArrayList<Player>();
    }
    
    /*
     * This method adds a player to the plist ArrayList
     * @param Object a given Player object that will be added to the ArrayList
     */
    public void addPlayer(Object o){
    	Player o2 = (Player) o;
    	plist.add(o2);
    }
    
    /*
     * This method will remove a desired player from the plist ArrayList
     * @param name the name of the player that will be removed from the plist ArrayList
     */
    public boolean removePlayer(String name){
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getName().equals(name)){
    			plist.remove(i);
    			return true;
    		}
    	}
    	return false;
    }
    
    /*
     * This method will return a String array of the player numbers based on the desired country needed to be searched
     * @param country the country that needed to be searched for the player number
     * @return String array of the searched country's player numbers
     */
    public String[] searchPlayerNumber(String country){
    	int count = 0;
    	int j = 0;
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getCountry().equals(country)){
    			count++;
    		}
    	}
    	String[] numbers = new String[count];
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getCountry().equals(country) && j < numbers.length){
    			numbers[j] = plist.get(i).getNumber();
    			j++;
    		}
    	}
    	return numbers;
    }
    
    /*
     * This method sorts the players in the plist based on the number of goals scored by the player objects
     * @param country the name of the country that wants to have it's players sorted accordingly
     * @param tlist the ArrayList that contains the reference ID so that the allPlayerByTeam method can be called to return a String accordingly
     * @return returns the String output of the sorted team for the specific country
     */
    public String sortGoals(String country, ArrayList<Team> tlist){
    	ArrayList <Player> output = new ArrayList<Player>();
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getCountry().equals(country)){
    			output.add(plist.get(i));
    		}
    	}
    	
    	for(int i = 0; i < plist.size() - 1; i++){
    		for(int j = 1; j < plist.size() - i; j++){
    		if(plist.get(j-1).getGoals() < (plist.get(j).getGoals())){
    			Player temp = plist.get(j-1);
    			plist.set(j-1,plist.get(j));
    			plist.set(j, temp);
    		}
    		}
    	}
    	
    	return allPlayersByTeam(country, tlist);
    }
    
    /*
     * This method updates the goals for the players in the plist
     * @param name the name of the player that wishes to have his/her goals updated
     * @param goals the new goals of the specified player
     * @return boolean value of whether the player existed or not
     */
    public boolean updateGoals(String name, int goals){
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getName().equals(name)){
    			plist.get(i).updateGoals(goals);
    			return true;
    		}
    	}
    	return false; 
    }
    
    /*
     * This method sorts the desired team based on the number of caps for the individual player objects
     * @param country the name of the country that will be used as a reference to find players that have play for the team with the same reference name
     * @param tlist the Team ArrayList that will be used as a reference so that the allPlayersByTeam method can be used to give a coherent String output for the team and the players
     * @return String formatted to show the list of players sorted on caps
     */
    public String sortCaps(String country, ArrayList<Team> tlist){
    	ArrayList <Player> output = new ArrayList<Player>();
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getCountry().equals(country)){
    			output.add(plist.get(i));
    		}
    	}
    	
    	for(int i = 0; i < plist.size() - 1; i++){
    		for(int j = 1; j < plist.size() - i; j++){
    		if(plist.get(j-1).getCaps() < (plist.get(j).getCaps())){
    			Player temp = plist.get(j-1);
    			plist.set(j-1,plist.get(j));
    			plist.set(j, temp);
    		}
    		}
    	}
    	
    	return allPlayersByTeam(country, tlist);
    }
    
    /*
     * This method updates the number of caps for a specified player
     * @param name the name of the player that wishes to have his/her caps updated
     * @param caps the new number of caps 
     * @return boolean value on whether the player was found in the plist
     */
    public boolean updateCaps(String name, int caps){
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getName().equals(name)){
    			plist.get(i).updateCaps(caps);
    			return true;
    		}
    	}
    	return false; 
    }
    
    /*
     * This method prints out all of the players from a team along with their team information
     * @param country this String name of the country will be used as a reference to find players with the same country
     * @param tlist this ArrayList will be used to extract similar information between teams and players (the country) 
     * @return a formatted string of the team and player information
     */
    public String allPlayersByTeam(String country, ArrayList<Team> tlist){
    	ArrayList <Player> output = new ArrayList<Player>();
    	String s = "";
    	int index = 0;
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getCountry().equals(country)){
    			output.add(plist.get(i));
    		}
    	}
    	
    	for(int k = 0; k < tlist.size(); k++){
    		if(tlist.get(k).getTeam().equals(country)){
    			index = k;
    			break;
    		}
    	}
    	
    	for(int j = 0; j < output.size(); j++){
    		s = s + String.format("%20s %15s %15s %15s %15s %15s", output.get(j).getPos(), output.get(j).getName(), output.get(j).getAge(), output.get(j).getNumber(), output.get(j).getCaps(),output.get(j).getGoals());
    		if(j < output.size() - 1){
    		s= s + "\n" + String.format("%15s %15s %15s", tlist.get(index).getTeam(), tlist.get(index).getCoach(), tlist.get(index).getRanking());	
    		}
    	}
    	return s + "\n";
    }
    
    /*
     * This method will return a formatted String of the players and their ages
     * @param country the name of the country that the player(s) play for 
     * @param tlist the Team ArrayList that will be used as reference to get team information for the final output
     * @return a formatted String of the team information and player information (with only age) that will be displayed to the user in the JOptionPane
     */
    public String allPlayersByAge(String country, ArrayList<Team> tlist){
    	ArrayList <Player> output = new ArrayList<Player>();
    	String s = "";
    	int index = 0;
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getCountry().equals(country)){
    			output.add(plist.get(i));
    		}
    	}
    	
    	for(int k = 0; k < tlist.size(); k++){
    		if(tlist.get(k).getTeam().equals(country)){
    			index = k;
    			break;
    		}
    	}
    	
    	for(int j = 0; j < output.size(); j++){
    		s = s + String.format("%20s %15s %15s", output.get(j).getPos(), output.get(j).getName(), output.get(j).getAge());
    		if(j < output.size() - 1){
    		s= s + "\n" + String.format("%15s %15s %15s", tlist.get(index).getTeam(), tlist.get(index).getCoach(), tlist.get(index).getRanking());	
    		}
    	}
    	return s + "\n";
    
    }
    
    /*
     * This method will return a formatted string of players and their respective teams and will only show their number of goals scored
     * @param country the name of the country that the player plays for
     * @param tlist the Team ArrayList that will be used to get formatted information regarding each team. This will be used for the final output.
     * @return formatted string of the players and their respective goals as well as other information in a specific format.
     */
    public String allPlayersByGoals(String country, ArrayList<Team> tlist){
    	ArrayList <Player> output = new ArrayList<Player>();
    	String s = "";
    	int index = 0;
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getCountry().equals(country)){
    			output.add(plist.get(i));
    		}
    	}
    	
    	for(int k = 0; k < tlist.size(); k++){
    		if(tlist.get(k).getTeam().equals(country)){
    			index = k;
    			break;
    		}
    	}
    	
    	for(int j = 0; j < output.size(); j++){
    		s = s + String.format("%20s %15s %15s", output.get(j).getPos(), output.get(j).getName(), output.get(j).getGoals());
    		if(j < output.size() - 1){
    		s= s + "\n" + String.format("%15s %15s %15s", tlist.get(index).getTeam(), tlist.get(index).getCoach(), tlist.get(index).getRanking());	
    		}
    	}
    	return s + "\n";
    }
    
    /*
     * This method will return information about players and their GPC (goals per cap)
     * @param country the name of the country that the player plays for
     * @param tlist the Team ArrayList that will be used to get information from for the final formatted string
     * @return formatted string of the team information as well as the player information for the final ouput
     */
    public String allPlayersByGoalsPerCap(String country, ArrayList<Team> tlist){
    	ArrayList <Player> output = new ArrayList<Player>();
    	String s = "";
    	int index = 0;
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getCountry().equals(country)){
    			output.add(plist.get(i));
    		}
    	}
    	
    	for(int k = 0; k < tlist.size(); k++){
    		if(tlist.get(k).getTeam().equals(country)){
    			index = k;
    			break;
    		}
    	}
    	
    	for(int j = 0; j < output.size(); j++){
    		s = s + String.format("%20s %15s %15s", output.get(j).getPos(), output.get(j).getName(), output.get(j).getGoalPerCap()) + "\n";
    		if(j < output.size() - 1){
    		s= s + "\n" + String.format("%15s %15s %15s", tlist.get(index).getTeam(), tlist.get(index).getCoach(), tlist.get(index).getRanking());	
    		}
    	}
    	return s;
    }
    
    /*
     * This method returns an array of the player names that play for a specific country
     * @param country the specified name of the country that is being searched for
     * @return a String array of the player names
     */
    public String[] searchPlayerName(String country){
    	int count = 0;
    	int index = 0;
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getCountry().equals(country)){
    			count++;
    		}
    	}
    	String[] names = new String[count];
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getCountry().equals(country) && index < names.length){
    			names[index] = plist.get(i).getName();
    			index++;
    		}
    	}
    	return names;
    }
    
    /*
     * This method will "back-up" information by formatting the information in the plist and player objects in a string that can be written to a file
     * @return the formatted string of the team name and the player information
     */
    public String backup(){
    	String s = "";
    	for(int i = 0; i < plist.size(); i++){
    		s = s + plist.get(i).getPos() + "\n" + plist.get(i).getName() + "\n" + plist.get(i).getAge() + "\n" + plist.get(i).getNumber() 
    			+ "\n" + plist.get(i).getCaps() + "\n" + plist.get(i).getGoals() + "\n" + plist.get(i).getCountry() + "\n";
    	}
    	return plist.size() + "\n" + s;
    }
    
    /*
     * This method finds the name of the player within the plist
     * @param name the name of the player that the user wishes to find in the plist
     * @return a formatted string of the found player information (if it is in the plist)
     */
    public String findName(String name){
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getName().equals(name)){
    			return String.format("%20s %15s %15s %15s %15s %15s", plist.get(i).getPos(), plist.get(i).getName(), plist.get(i).getAge(), plist.get(i).getNumber(), plist.get(i).getCaps(),plist.get(i).getGoals());
    		}
    	}
    	return "not found";
    }
    
    /*
     * This method finds the player based on the given player number
     * @param number the number of the player 
     * @return a formatted string of the found player(if it is in the plist)
     */
    public String findNumber(String number){
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getNumber().equals(number)){
    			return String.format("%20s %15s %15s %15s %15s %15s", plist.get(i).getPos(), plist.get(i).getName(), plist.get(i).getAge(), plist.get(i).getNumber(), plist.get(i).getCaps(),plist.get(i).getGoals());
    		}
    	}
    	return "not found";
    }
    
    /*
     * This method finds all the players specific to one given team (partial show)
     * @param country the name of the country
     * @return formatted string of all the players on the team of the given country name
     */
    public String findPlayersOnTeam(String country){
    	String s = "";
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getCountry().equals(country)){
    			s = s + String.format("%20s %15s %15s %15s %15s %15s", plist.get(i).getPos(), plist.get(i).getName(), plist.get(i).getAge(), plist.get(i).getNumber(), plist.get(i).getCaps(),plist.get(i).getGoals()) + "\n";
    	}
    }
    return s;
    
}
}
