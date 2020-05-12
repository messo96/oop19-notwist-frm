package rombo.discuss;

public class StrikeImplements extends BaseAccountImplements implements Strike {
	
	/*Fields.*/
	private int Strike;
	
	/*Builders.*/
	
	/*Base builder.*/
	public StrikeImplements(int ID) {
		super(ID);
		this.Strike = 0;
	}
	
	/*Advace Builder.*/
	public StrikeImplements(int ID , String UserName) {
		super(ID,UserName);
		this.Strike = 0;
	}

	
	/*Method for add a strike.*/
	public void ADDStrike() {
		this.Strike++;
	}
	
	/*Method for remove a strike.*/
	public void RemoveStrike() {
		this.Strike--;
	}

	/*Method for remove all strike.*/
	public void RemoveAllStrike() {	
		this.Strike=0;
	}
	
	/*Method that return the number of the strikes.*/
	public int GetNumberOfStrikes() {
		return this.Strike;
	}

	
	

}
