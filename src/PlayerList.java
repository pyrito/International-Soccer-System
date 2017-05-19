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
	
    public PlayerList() {
    	plist = new ArrayList<Player>();
    }
    
    public void addPlayer(Object o){
    	Player o2 = (Player) o;
    	plist.add(o2);
    }
    
    public boolean removePlayer(String name){
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getName().equals(name)){
    			plist.remove(i);
    			return true;
    		}
    	}
    	return false;
    }
    
    public String[] searchPlayerNumber(String country){
    	int count = 0;
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getCountry().equals(country)){
    			count++;
    		}
    	}
    	String[] names = new String[count];
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getCountry().equals(country)){
    			names[i] = plist.get(i).getNumber();
    		}
    	}
    	return names;
    }
    
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
    
    public boolean updateGoals(String name, int goals){
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getName().equals(name)){
    			plist.get(i).updateGoals(goals);
    			return true;
    		}
    	}
    	return false; 
    }
    
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
    
    public boolean updateCaps(String name, int caps){
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getName().equals(name)){
    			plist.get(i).updateCaps(caps);
    			return true;
    		}
    	}
    	return false; 
    }
    
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
    	return s;
    }
    
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
    	return s;
    
    }
    
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
    	return s;
    }
    
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
    		s = s + String.format("%20s %15s %15s", output.get(j).getPos(), output.get(j).getName(), output.get(j).getGoalPerCap());
    		if(j < output.size() - 1){
    		s= s + "\n" + String.format("%15s %15s %15s", tlist.get(index).getTeam(), tlist.get(index).getCoach(), tlist.get(index).getRanking());	
    		}
    	}
    	return s;
    }
    
    public String[] searchPlayerName(String country){
    	int count = 0;
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getCountry().equals(country)){
    			count++;
    		}
    	}
    	String[] names = new String[count];
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getCountry().equals(country)){
    			names[i] = plist.get(i).getName();
    		}
    	}
    	return names;
    }
    
    public String backup(){
    	String s = "";
    	for(int i = 0; i < plist.size(); i++){
    		s = s + plist.get(i).getPos() + "\n" + plist.get(i).getName() + "\n" + plist.get(i).getAge() + "\n" + plist.get(i).getNumber() 
    			+ "\n" + plist.get(i).getCaps() + "\n" + plist.get(i).getGoals() + "\n" + plist.get(i).getCountry() + "\n";
    	}
    	return plist.size() + "\n" + s;
    }
    
    public String findName(String name){
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getName().equals(name)){
    			return String.format("%20s %15s %15s %15s %15s %15s", plist.get(i).getPos(), plist.get(i).getName(), plist.get(i).getAge(), plist.get(i).getNumber(), plist.get(i).getCaps(),plist.get(i).getGoals());
    		}
    	}
    	return "not found";
    }
    
    public String findNumber(String number){
    	for(int i = 0; i < plist.size(); i++){
    		if(plist.get(i).getNumber().equals(number)){
    			return String.format("%20s %15s %15s %15s %15s %15s", plist.get(i).getPos(), plist.get(i).getName(), plist.get(i).getAge(), plist.get(i).getNumber(), plist.get(i).getCaps(),plist.get(i).getGoals());
    		}
    	}
    	return "not found";
    }
    
}