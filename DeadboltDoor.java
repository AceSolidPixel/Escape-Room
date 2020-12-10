import java.util.Random; 
public class DeadboltDoor implements Door{
  /** Stores the minimum possible value for the menu */
  public int minValue;
  /** Stores the maximum possible value for the menu */
  public int maxValue;
  /** Stores the position of the first deadbolt */
  private boolean bolt1;
  /** Stores the position of the second bolt deadbolt */
  private boolean bolt2;
  /** Object that will be used for the randomization of which bolt is engaged and which is not. */
  Random rand = new Random();

  /*
  * Constructor for this class. Sets the values for bolt1 and bolt2
  */
  public DeadboltDoor(){
    minValue = 1;
    maxValue = 2;
    bolt1 = rand.nextBoolean();
    bolt2 = rand.nextBoolean();
  }

/*
* Returns a string description of the door.
*
* @return - Returns a string description of the door.
*/
  @Override
  public String examine(){
    return "A door with two deadbolts. Both need to be unlocked for the door to open, but you can’t tell which are locked or unlocked.";
  }
/*
* Returns a list of options the user can do to unlock the door.
*
* @return - Returns a list of options the user can do to unlock the door.
*/
  @Override
  public String menu(){
    return "1. Toggle Bolt 1 \n2. Toggle Bolt 2";
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
      bolt1 = !bolt1;
      return "You toggled the first deadbolt";
    }
    else{
      bolt2 = !bolt2;
      return "You toggled the second deadbolt";
    } 
  }
/*
* Tests to see if the door has been unlocked, returns true if it is
* @return - returns true or false depending on whether or not they picked the correct place to look
*/
  @Override
  public boolean open(){
    if (bolt1 == false && bolt2 == false)
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
    if((bolt1 == false && bolt2 == true) || (bolt1 == true && bolt2 == false))
      return "One is in the correct position.";
    else if(bolt1 == true && bolt2 == true)
      return "Neither seem to be in the correct position.";
    return "";
  }
/*
* Returns the success message for the door being unlocked successfully.
*/
  @Override
  public String success(){
    return "Congratulations, you opened this door.";
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