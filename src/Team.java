/**
 * @(#)Team.java
 *
 *
 * @author Karthik Velayutham
 * @version 1.00 2017/5/12
 */


public class Team {
	
	private String countryName;
	private String coach;
	private int ranking;
	
    public Team() {
    	countryName = "None";
    	coach = "None";
    	ranking = -1;
    }
    
    public Team(String country, String coach, int rank){
    	countryName = country;
    	this.coach = coach;
    	ranking = rank;
    }
    
    public String getTeam(){
    	return countryName;
    }
    
    public String getCoach(){
    	return coach;
    }
    
    public int getRanking(){
    	return ranking;
    }
    
    public void changeName(String name){
    	countryName = name;
    }
    
    public void changeCoach(String coach){
    	this.coach = coach;
    }
    
    public void changeRanking(int rank){
    	ranking = rank;
    }
    
    public String toString(){
    	return "hi";	
    }
    
    public boolean compareTo(Object o){
    	Team o2 = (Team) o;
    	return true;
    }
    
    public boolean equals(Object o){
    	return true;	
    }
    
}