package rombo.new_class;

import java.util.Optional;

/*Simple class to salve a like or dislike for a user*/
public interface LikeAndDisLike {
	
	public int GetIDUser();
	
	public int GetIDDiscussion();
	
	public Optional<Boolean> IsLike();
	
	public Optional<Boolean> IsDisLike();
	
}
