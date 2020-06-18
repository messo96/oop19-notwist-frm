package model.base;

public class LikeSet {
	private Integer id;
	private Boolean like;
	private Boolean dislike;
	private Integer idUser;
	private Integer idDiscussion;

	public LikeSet(final Integer id, final Boolean isLike, final Boolean isDislike, final Integer idUser,
			final Integer idDiscussion) {
		this.id = id;
		this.like = isLike;
		this.dislike = isDislike;
		this.idUser = idUser;
		this.idDiscussion = idDiscussion;
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

	public Integer getIdDiscussion() {
		return this.idDiscussion;
	}

}
