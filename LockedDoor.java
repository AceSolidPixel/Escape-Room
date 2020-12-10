import java.util.Random;

public class LockedDoor implements Door {

  /** Stores the minimum possible value for the menu */
  public int minValue = 1;
  /** Stores the maximum possible value for the menu */
  public int maxValue = 3;
  /** Stores the loction of the key */
  private int keyLocation;
  /** Stores the loaction in which the user will look for the key */
  private int keyChoice;
  /** Object that will be used for the randomization of where the key is */
  Random rand = new Random();
/*
* Constructor for this class. Sets the value for where the key is hidden
*/
  public LockedDoor(){
    keyLocation = (rand.nextInt(3) + 1);
  }
/*
* Returns a string description of the door.
*
* @return - Returns a string description of the door.
*/
  @Override
  public String examine() {
    return "A door that can be opened with a key. Look around to see if can find it.";
  }
/*
* Returns a list of options the user can do to unlock the door.
*
* @return - Returns a list of options the user can do to unlock the door.
*/
  @Override
  public String menu(){
    return "1. Look Under Mat \n2. Look Under Flower Pot \n3. Look Under Fake Rock";
  }
/*
* Returns a string based on whether or not the user chose to look in the right place.
*
* @param - Passes in the user's input on where to look.
* @return - returns whether or not the user picked the correct place.
*/
  @Override
  public String unlock(int option){
    keyChoice = option;
    return "You search that area...";
  }
/*
* Tests to see if the door has been unlocked, returns true if it is
* @return - returns true or false depending on whether or not they picked the correct place to look
*/
  @Override
  public boolean open(){
    if (keyChoice == keyLocation)
      return true;
    else
      return false;
  }
/*
* Returns a clue to help the user unlock the door.
* @return - returns a clue to help the user unlock the door.
*/
  @Override 
  public String clue()
  {
    return "Look somewhere else.";
  }
  /*
  * Returns the success message for the door being unlocked successfully.
  */
  @Override
  public String success(){
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