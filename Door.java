public interface Door {

	/** return string description */
  public String examine();

	/** return menu for doors */
  public String menu();
  /** attempt to open the door */
  public String unlock(int option);
	
	/** returns true after testing if door is open */
  public boolean open();

  /** returns a clue when the door is unsuccessfully opened */
	public String clue();
  
  /** Returns a string when successful in opening door*/
	public String success();
   /*Returns the minVal */ 
   public int getMin();
  /*Returns the maxVal */ 
   public int getMax();
   
}