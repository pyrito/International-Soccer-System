/**
 * @(#)TeamList.java
 *
 *
 * @author Karthik Velayutham
 * @version 1.00 2017/5/12
 */
import java.util.*;

public class TeamList {
	
	ArrayList<Team> tlist;
    /*
     *Creates the default constructor for the TeamList class
     */
    public TeamList() {
    	tlist = new ArrayList<Team>();
    }
    
    /*
     *This method adds teams to the tlist ArrayList
     *@param Team object that the user wishes to add
     */
    public void addTeam(Team o){
    	tlist.add(o);
    }
    
    /*
     *This method removes a team from the tlist ArrayList
     *@param Team object that wishes to be removed from the tlist ArrayList
     */
    public boolean removeTeam(String name){
    	for(int i = 0; i < tlist.size(); i++){
    		if(tlist.get(i).getTeam().equals(name)){
    			tlist.remove(i);
    			return true;
    		}
    	}
    	return false;
    }
    
    /*
     *This method returns the available teams for the user to search the player in
     *@return returns the array of the team names
     */
    public String[] findTeam(){
    	String[] countries = new String[tlist.size()];
    	for(int i = 0; i < tlist.size(); i++){
    		countries[i] = tlist.get(i).getTeam();
    	}
    	return countries;	
    }
    
    /*
     *This method converts the information to a string format
     *@return string format of the tlist
     */
    public String toString(){
    	String s = "";
    	for(int i = 0; i < tlist.size(); i++){
    		s = s + String.format("%15s %15s %15s", tlist.get(i).getTeam(), tlist.get(i).getCoach(), tlist.get(i).getRanking());
    	}
    	return s;	
    }
    
    /*This method sorts the team of choice by the number of goals scored
     *@param countryID is the the name of the country, pl is the PlayerList that will be added.
     */
    public String sortGoal(PlayerList pl){
    	String s = "";
    	for(int i = 0; i < tlist.size(); i++){
    		s = s + String.format("%15s %15s %15s", tlist.get(i).getTeam(), tlist.get(i).getCoach(), tlist.get(i).getRanking()) 
    		+ pl.sortGoals(tlist.get(i).getTeam(), tlist);
    	}
    	return s;
    }
    
    /*
     *This method sorts the team based on the number of caps. The PlayerList is passed through and its method is called as a reference.
     *@param PlayerList the other object that will compare the caps based on the players
     *@return a formatted String of all the team information and player information in a sorted fashion
     */
    public String sortCaps(PlayerList pl){
    	String s = "";
    	for(int i = 0; i < tlist.size(); i++){
    		s = s + String.format("%15s %15s %15s", tlist.get(i).getTeam(), tlist.get(i).getCoach(), tlist.get(i).getRanking()) 
    		+ pl.sortCaps(tlist.get(i).getTeam(), tlist);
    	}
    	return s;
    } 
    
    /*
     *This method displays all the team information and player information. The PlayerList is passed through as a reference to call its own method which returns all the player information
     *@param PlayerList the list of player objects
     *@return the formatted String of all the teams and their respective player information separated with a space between each team
     */
    public String displayAll(PlayerList pl){
    	String s = "";
    	for(int i = 0; i < tlist.size(); i++){
    		s = s + String.format("%15s %15s %15s", tlist.get(i).getTeam(), tlist.get(i).getCoach(), tlist.get(i).getRanking()) 
    		+ pl.allPlayersByTeam(tlist.get(i).getTeam(), tlist) + "\n";
    	}
    	return s;
    }
    
    /*
     *This method displays all the teams in the tlist in alphabetical order
     *@return String the formatted string of all the teams in alphabetical order with their coaches and ranks
     */
    public String displayAllTeams(){
    	String s = "";
    	if(tlist.size() == 1){
    		return String.format("%15s %15s %15s", tlist.get(0).getTeam(), tlist.get(0).getCoach(), tlist.get(0).getRanking());
    	}
    	for(int i = 0; i < tlist.size() - 1; i++){
    		for(int j = 1; j < tlist.size() - i; j++){
    		if(tlist.get(j-1).getTeam().compareTo(tlist.get(j).getTeam()) > 0){
    			Team temp = tlist.get(j-1);
    			tlist.set(j-1,tlist.get(j));
    			tlist.set(j, temp);
    		}
    		}
    	}
    	
    	for(int i = 0; i < tlist.size(); i++){
    		s = s + String.format("%15s %15s %15s", tlist.get(i).getTeam(), tlist.get(i).getCoach(), tlist.get(i).getRanking()) + "\n";
    	}
    	return s;	
    }	
    
    /*
     *This method displays the partial show of only the players and their goals
     *@param PlayerList the list of player objects
     *@return the formatted String of all the teams and their respective player information
     */
    public String displayByGoals(PlayerList pl){
    	String s = "";
    	for(int i = 0; i < tlist.size(); i++){
    		s = s + String.format("%15s %15s %15s", tlist.get(i).getTeam(), tlist.get(i).getCoach(), tlist.get(i).getRanking()) 
    		+ pl.allPlayersByGoals(tlist.get(i).getTeam(), tlist);
    	}
    	return s;	
    }
    
    /*
     *This method does a partial show with the player name and age
     *@param PlayerList the list of player objects
     *@return the formatted String of team information and the player
     */
    public String displayByAge(PlayerList pl){
    	String s = "";
    	for(int i = 0; i < tlist.size(); i++){
    		s = s + String.format("%15s %15s %15s", tlist.get(i).getTeam(), tlist.get(i).getCoach(), tlist.get(i).getRanking()) 
    		+ pl.allPlayersByAge(tlist.get(i).getTeam(), tlist);
    	}
    	return s;	
    }
    
    /*
     *This method shows only the player and the GPC (goals per cap)
     *@param PlayerList the list of player objects
     *@return the formatted String of the team information and the player's GPC
     */
    public String displayByGoalsPerCap(PlayerList pl){
    	String s = "";
    	for(int i = 0; i < tlist.size(); i++){
    		s = s + String.format("%15s %15s %15s", tlist.get(i).getTeam(), tlist.get(i).getCoach(), tlist.get(i).getRanking()) 
    		+ pl.allPlayersByGoalsPerCap(tlist.get(i).getTeam(), tlist);
    	}
    	return s;		
    }
    
    /*
     * This method put all of the contents of the tlist ArrayList in String format so that it can be read by a file
     * @return String output of all the team information so that it can all be copied on to a file
     */
    public String backup(){
    	String s = "";
    	for(int i = 0; i < tlist.size(); i++){
    		s = s + tlist.get(i).getTeam() + "\n" + tlist.get(i).getCoach() + "\n" + tlist.get(i).getRanking() + "\n";
    	}
    	return tlist.size() + "\n" + s;
    }
    
    /*
     * This method finds which countries in the tlist matched the country that needed to be searched
     * @param country the country that wished to be searched for
     * @return String output of the country that wants to be found
     */
    public String findTeam(String country){
    	int index = 0;
    	for(int i = 0; i < tlist.size(); i++){
    		if(tlist.get(i).getTeam().equals(country)){
    			index = i;
    		}
    	}
    	return String.format("%15s %15s %15s", tlist.get(index).getTeam(), tlist.get(index).getCoach(),tlist.get(index).getRanking());
    }

}