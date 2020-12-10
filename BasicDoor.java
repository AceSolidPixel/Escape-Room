import java.util.Random;
public class BasicDoor implements Door {
  /** Stores the minimum possible value for the menu */
  public int minValue;
  /** Stores the maximum possible value for the menu */
  public int maxValue;
	private boolean push; 
	private boolean input; 
  /** Object that will be used for the randomization of where the key is */
  Random rand = new Random();

  public BasicDoor() {  
    minValue = 1;
    maxValue = 2;
    input = rand.nextBoolean();
	}

	/*
	* Returns a string description of the door.
	*
	* @return - Returns a string description of the door.
	*/
	@Override
	public String examine() {
		return "A door that can be pushed or pulled.";
	}

	/*
	* Returns the user menu for this specific door.
	*
	* @return - Returns a string description of the user menu.
	*/
	@Override
	public String menu() {
		return "1. Push \n2. Pull";
	}

	/*
	* Returns a string based on whether the user toggled the first or second deadbolt
	*
	* @param - Passes in the user's input on which deadbolt to toggle
	* @return - returns which bolt was toggled
	*/
	@Override
	public String unlock(int option){
    if(option == 1){
      input = true;
      return "You try to push the door";
    }
    else{
      input = false;
      return "You try to pull the door";
    }
  }

	/*
	* Tests to see if the door has been unlocked, returns true if it is
	* @return - returns true or false depending on whether or not they picked the correct place to look
	*/
	@Override
	public boolean open(){
    if(input == push){
      System.out.println(success());
      return true;
    }
    else{
      System.out.println(clue());
      return false;
    }
  }

	/*
	* Returns a clue to help the user unlock the door.
	* @return - returns a clue to help the user unlock the door.
	*/
	@Override
	public String clue() {
		return "Try the other direction.";
	}
	
	/*
	* Returns the success message for the door being unlocked successfully.
	*/
	@Override
	public String success() {
		return "Congratulations, you opened a door.";
	}	
   
  /*
  * Returns the minVal
  * @return - returns minValue instance variable
  */
  public int getMin()
  {
    return minValue;
  }
  
  /*
  * Returns the maxVal
  * @return - returns maxValue instance variable
  */
  public int getMax()
  {
   return maxValue;
  }
}