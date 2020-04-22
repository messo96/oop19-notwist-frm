package rombo.discuss;

import java.util.*;

public class LikeAndDislikeImplements implements LikeAndDislike {
	
	/*Fields.*/
	final private static int LIKE = 1;
	final private static int DISLIKE = -1;
	
	private int NumberLike;
	private int NumberDisLike;
	
	HashMap<BaseAccountImplements, Integer> User = new HashMap<BaseAccountImplements, Integer>();
	
	/*Builder.*/
	public LikeAndDislikeImplements() {
		this.NumberLike = 0;
		this.NumberDisLike = 0;
	}
	
	
	/*method for add like, if the same user pouted  dislike the count of dislike id decrement.*/
	public void ADDLike(BaseAccountImplements ID) {
		
		/*Control if this is a new user.*/
		if(User.containsKey(ID)) {
			/*Control if the user made other action.*/
			if(User.get(ID) == DISLIKE) {
				this.NumberDisLike--;
				this.NumberLike++;
			}
		}
		/*If this is a new user*/
		else {
			User.put(ID, LIKE);
			this.NumberLike++;
		}
		

	}

	/*Method that return the current number of like*/
	public int GetLikeNumber() {
		return this.NumberLike;
	}

	
	/*method for add dislike, if the same user pouted  like the count of like id decrement.*/
	public void ADDDislike(BaseAccountImplements ID) {
		
		/*Control if this is a new user.*/
		if(User.containsKey(ID)) {
			/*Control if the user made other action.*/
			if(User.get(ID) == LIKE) {
				this.NumberLike--;
				this.NumberDisLike++;
			}
		}
		/*If this is a new user*/
		else {
			User.put(ID, DISLIKE);
			this.NumberDisLike++;
		}

	}

	/*Method that return the current number of like*/
	public int GetDislikeNumber() {
		return this.NumberDisLike;
	}

}
