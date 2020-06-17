package model.base;

public class LikeSet {
	private Boolean like;
	private Boolean dislike;
	private Integer idUser;
	private Integer idDiscussion;

	public LikeSet(final Boolean isLike, final Boolean isDislike, final Integer idUser, final Integer idDiscussion) {
		this.like = isLike;
		this.dislike = isDislike;
		this.idUser = idUser;
		this.idDiscussion = idDiscussion;
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
	
	public Integer getIdDiscussion() {
		return this.idDiscussion;
	}

}
