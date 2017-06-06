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
	
    /*
     *The default constructor for the Team class
     */
    public Team() {
    	countryName = "None";
    	coach = "None";
    	ranking = -1;
    }
    
    /*
     *The overloaded constructor for the Team class
     *@param country the country of the team
     *@param the coach name of the team
     *@param the rank of the team
     */
    public Team(String country, String coach, int rank){
    	countryName = country;
    	this.coach = coach;
    	ranking = rank;
    }
    
    /*
     *This method returns the name of the team
     *@return the name of the country
     */
    public String getTeam(){
    	return countryName;
    }
    
    /*
     *This method returns the name of the coach
     *@return the name of the coach
     */
    public String getCoach(){
    	return coach;
    }
    
    /*
     *This method returns the ranking number of the team
     *@return the team ranking
     */
    public int getRanking(){
    	return ranking;
    }
    
    /*
     *This method sets the new name of a player
     *@param name the new name of the player
     */
    public void changeName(String name){
    	countryName = name;
    }
    
    /*
     *This method changes the name of the coach
     *@param coach the new name of the coach
     */
    public void changeCoach(String coach){
    	this.coach = coach;
    }
    
    /*
     *This method changes the ranking of the team
     *@param rank the new rank of the team
     */
    public void changeRanking(int rank){
    	ranking = rank;
    }
    
    /*
     *This method writes the format of the team information that will be printed out
     *@return the string format of the team information
     */
    public String toString(){
    	String s = String.format("%15s %15s %15s", getTeam(), getCoach(),getRanking());
    	return s;	
    }
    
    /*
     *This method checks if the object in the parameter has a name that is above the alphabetical list
     *@param Object the other team object
     *@return boolean value of whether the parameter name is greater than the the other team name
     */
    public boolean compareTo(Object o){
    	Team o2 = (Team) o;
    	if(o2.getTeam().compareTo(getTeam()) > 0){
    		return false;
    	}
    	return true;
    }
    
    /*
     *This method checks if the object in the parameter has an equal ranking
     *@param Object the other team object
     *@return the boolean value of whether the parameter has an equal ranking
     */
    public boolean equals(Object o){
    	Team o2 = (Team) o;
    	if(o2.getRanking() == getRanking()){
    		return true;
    	}
    	return false;	
    }
    
}