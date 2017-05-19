/**
 * @(#)Player.java
 *
 *
 * @author Karthik Velayutham
 * @version 1.00 2017/5/12
 */


public class Player {
	
	private String playerName;
	private String age;
	private String teamNumber;
	private double caps;
	private String position;
	private String countryName;
	private double goals;
	
    public Player() {
    	
    }
    
    public Player(String name, String age, String teamNo, double appearances, String pos, String country, double inputGoals){
    	playerName = name;
    	this.age = age;
    	teamNumber = teamNo;
    	caps = appearances;
    	position = pos;
    	countryName = country;
    	goals = inputGoals;
    }
    
    /*
     * This method updates the number of caps for a specified player
     * @param inputCaps the new number of caps
     */
    public void updateCaps(int inputCaps){
    	caps = inputCaps;
    }
    
    /*
     * This method updates the number of goals for a specified player
     * @param inputGoals the new number of goals
     */
    public void updateGoals(int inputGoals){
    	goals = inputGoals;
    }
    
    /*
     * This method returns the name of the player
     * @return the name of the player
     */
    public String getName(){
    	return playerName;
    }
    
    /*
     * This method returns the name of the country that the player plays for (ID)
     * @return the name of the country team
     */
    public String getCountry(){
    	return countryName;
    }
    
    public String getAge(){
    	return age;
    }
    
    public String getPos(){
    	return position;
    }
    public int getCaps(){
    	return (int)caps;
    }
    
    public String getNumber(){
    	return teamNumber;
    }
    
    public int getGoals(){
    	return (int)goals;
    }
    
    public double getGoalPerCap(){
    	return goals / caps;
    }
    
    
}