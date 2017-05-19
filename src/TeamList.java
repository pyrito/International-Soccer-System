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
    	return "hi";	
    }
    
    /*
     *This method sorts the teams in the tlist by name
     */
    public void sortName(){
    	
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
    
    public String sortCaps(PlayerList pl){
    	String s = "";
    	for(int i = 0; i < tlist.size(); i++){
    		s = s + String.format("%15s %15s %15s", tlist.get(i).getTeam(), tlist.get(i).getCoach(), tlist.get(i).getRanking()) 
    		+ pl.sortCaps(tlist.get(i).getTeam(), tlist);
    	}
    	return s;
    } 
    
    public String displayAll(PlayerList pl){
    	String s = "";
    	for(int i = 0; i < tlist.size(); i++){
    		s = s + String.format("%15s %15s %15s", tlist.get(i).getTeam(), tlist.get(i).getCoach(), tlist.get(i).getRanking()) 
    		+ pl.allPlayersByTeam(tlist.get(i).getTeam(), tlist) + "\n";
    	}
    	return s;
    }
    
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
    
    public String displayByGoals(PlayerList pl){
    	String s = "";
    	for(int i = 0; i < tlist.size(); i++){
    		s = s + String.format("%15s %15s %15s", tlist.get(i).getTeam(), tlist.get(i).getCoach(), tlist.get(i).getRanking()) 
    		+ pl.allPlayersByGoals(tlist.get(i).getTeam(), tlist);
    	}
    	return s;	
    }
    
    public String displayByAge(PlayerList pl){
    	String s = "";
    	for(int i = 0; i < tlist.size(); i++){
    		s = s + String.format("%15s %15s %15s", tlist.get(i).getTeam(), tlist.get(i).getCoach(), tlist.get(i).getRanking()) 
    		+ pl.allPlayersByAge(tlist.get(i).getTeam(), tlist);
    	}
    	return s;	
    }
    
    public String displayByGoalsPerCap(PlayerList pl){
    	String s = "";
    	for(int i = 0; i < tlist.size(); i++){
    		s = s + String.format("%15s %15s %15s", tlist.get(i).getTeam(), tlist.get(i).getCoach(), tlist.get(i).getRanking()) 
    		+ pl.allPlayersByGoalsPerCap(tlist.get(i).getTeam(), tlist);
    	}
    	return s;		
    }
    
    public String displayGoals(){
    	return "hi";	
    }
    
    public String displayCaps(){
    	return "hi";	
    }
    
    public String backup(){
    	String s = "";
    	for(int i = 0; i < tlist.size(); i++){
    		s = s + tlist.get(i).getTeam() + "\n" + tlist.get(i).getCoach() + "\n" + tlist.get(i).getRanking() + "\n";
    	}
    	return tlist.size() + "\n" + s;
    }
    
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