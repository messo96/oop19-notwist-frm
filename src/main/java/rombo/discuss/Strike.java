package rombo.discuss;

/*This interface extend "BaseAccount" that represent the base information of every users.*/

public interface Strike extends BaseAccount {
	
	/*This method permit to add a strike for the user.*/
	public void ADDStrike();
	
	/*This method return the total number of strikes collected from the user.*/
	public int GetNumberOfStrikes();

}
