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
    
    /*
     *Overloaded constructor for player
     *@param name the name of the player
     *@param age the age of the player
     *@param teamNo the team number of the player
     *@param appearances the number of caps for the player
     *@param pos the position of the players on the field
     *@param country the country the player plays for
     *@param inputGoals the goals the player scored in total
     */
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
    
    /*
     *This method returns the age of the player
     *@return the age of the player object
     */
    public String getAge(){
    	return age;
    }
    
    /*
     *This method returns the position of the player
     *@return the position of the player
     */
    public String getPos(){
    	return position;
    }
    
    /*
     *This method returns the total number of caps of the player
     *@return the total number of caps from the player
     */
    public int getCaps(){
    	return (int)caps;
    }
    
    /*
     *This method returns the team number for the player
     *@return the player's team number
     */
    public String getNumber(){
    	return teamNumber;
    }
    
    /*
     *This method returns the goals scored by the player
     *@return the goals the player has scored
     */
    public int getGoals(){
    	return (int)goals;
    }
    
    /*
     *This method calcualtes the goals scored per cap
     *@return the goals per cap
     */
    public double getGoalPerCap(){
    	int temp = (int)((goals / caps) * 100);
    	return temp / 100.0;
    }
    
    
}