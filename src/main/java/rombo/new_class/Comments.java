package rombo.new_class;

import java.util.Optional;

/*A simple interface that permit to create comments*/

public interface Comments {
	
	/*Return Value*/

	public String GetComment();
	
	public int GetIDUser();
	
	public Optional<Integer> GetIDComment();
	
	public Optional<Integer> GetIDDiscussion();
	
	

}
