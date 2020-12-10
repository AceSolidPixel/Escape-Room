//Prince Angulo
//Lab 8

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
class Main 
{
  /** Object that will be used for the randomization of where the key is */
  static Random rand = new Random();
  public static void main(String[] args){
    for(int i = 0; i < 3; i++)
    {
      int doorType = rand.nextInt(3);
      Door d;
      switch(doorType){
        case 0:
          d = new BasicDoor();
          break;
        case 1:
          d = new LockedDoor();
          break;
        case 2:
          d = new DeadboltDoor();
          break;
        default:
          d = new BasicDoor();
          break;
      }
      openDoor(d);
    }
    System.out.println("Congratulations! You escaped...this time.");
  }
/*
* OpenDoor loops until the user manages to open the door
* @param d - randomized Door object that is passed from main
*/
	public static void openDoor(Door d) {
    do{
		System.out.println(d.examine());
    System.out.println(d.menu());
    int input = getIntRange(d.getMin(), d.getMax());
    System.out.println(d.unlock(input));
    if((d.open()) == true){
      System.out.println(d.success());
      break;
    }
    else
      System.out.println(d.clue());
    }while(d.open() == false);
	}

/*
*  The getIntRange method provides input validation for the menus, will repeatedly run until the user inputs a valid input
*  
*  @param int low - An integer that represents the lowest possible valid input from the user
*  @param int high - An integer that represents the highest possible valid input from the user
*  @return - returns the validated input from the user
*/
  public static int getIntRange(int low, int high)
  {
    Scanner in = new Scanner(System.in);
    boolean repeat = true;
    int returnVal = 0;
    while (repeat)
    {
      try
      {
        returnVal = in.nextInt();
        if (returnVal <= high && returnVal >= low)
        {
            repeat = false;
        }
        else
        {
            System.out.println("Invalid Input");
        }
      }catch(InputMismatchException e)
      {
        if (in.hasNext())
        {
            String stuff = in.next();
        }
        System.out.println("Invalid Input");
      }
    }
    return returnVal; 
  }

}