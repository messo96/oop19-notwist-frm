package model.base;

import java.util.Optional;

public class LikeSet {
	private Integer id;
	private Boolean like;
	private Boolean dislike;
	private Integer idUser;
	private Optional<Integer> idDiscussion;
	private Optional<Integer> idComment;

	public LikeSet(final Integer id, final Boolean isLike, final Boolean isDislike, final Integer idUser,
			final Optional<Integer> idDiscussion, final Optional<Integer> idComment) {
		this.id = id;
		this.like = isLike;
		this.dislike = isDislike;
		this.idUser = idUser;
		this.idDiscussion = idDiscussion;
		this.idComment = idComment;
	}

	public Integer getId() {
		return this.id;
	}

	public Boolean getLike() {
		return this.like;
	}

	public Boolean getDislike() {
		return this.dislike;
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public Optional<Integer> getIdDiscussion() {
		return this.idDiscussion;
	}
	
	public Optional<Integer> getIdComment() {
		return this.idComment;
	}

}
