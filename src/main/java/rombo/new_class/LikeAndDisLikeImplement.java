package rombo.new_class;

import java.util.*;

public class LikeAndDisLikeImplement implements LikeAndDisLike {

	/* Fields */

	private final int IDUser;
	private final int IDDiscuss;
	private final Optional<Boolean> Like;
	private final Optional<Boolean> DisLike;

	/* builder */
	public LikeAndDisLikeImplement(final int IDUser, final int IDDiscuss, final Optional<Boolean> Like,
			final Optional<Boolean> DisLike) {

		this.Like = Like;
		this.DisLike = DisLike;
		this.IDUser = IDUser;
		this.IDDiscuss = IDDiscuss;

	}

	/* Return methods */

	public int GetIDUser() {
		return this.IDUser;
	}

	public int GetIDDiscussion() {
		return this.IDDiscuss;
	}

	public Optional<Boolean> IsLike() {
		if (this.Like.isPresent()) {
			return this.Like;
		} else {
			return Optional.empty();
		}
	}

	public Optional<Boolean> IsDisLike() {

		if (this.DisLike.isPresent()) {
			return this.DisLike;
		} else {
			return Optional.empty();
		}
	}

}
