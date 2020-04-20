package rombo.discuss;

import java.util.Optional;

public class BaseAccountImplements implements BaseAccount {

	/*Fields.*/
	private final int ID;
	private String UserName = null;
	
	/*Builders.*/
	
	/*Base builder.*/
	public BaseAccountImplements(int ID) {
		this.ID = ID;
	}
	
	/*Advance builder.*/
	public BaseAccountImplements(int ID , String UserName) {
		this.ID = ID;
		this.UserName = UserName;
	}
	
	
	/*Get methods.*/
	
	/*ID.*/
	public int GetID() {
		return this.ID;
	}

	/*UserName.*/
	public Optional<String> GetUserName() {
		if(this.UserName != null) {
			return Optional.of(this.UserName);
		}
		else {
			return Optional.empty();
		}
	}

}
