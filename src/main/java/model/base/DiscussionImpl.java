package model.base;

import java.util.Date;

public class DiscussionImpl implements Discussion {

	private Integer id;
	private Integer idUser;
	private String title;
	private String description;
	private Category category;
	private Date data;
	// maybe add List of comments ? Ask rombo for comments class

	public DiscussionImpl(final Integer id, final Integer idUser, final String title, final String description,
			final Category category, final Date data) {
		this.id = id;
		this.idUser = idUser;
		this.title = title;
		this.description = description;
		this.category = category;
		this.data = data;
	}

	public final String getTitle() {
		return title;
	}

	public final String getDescription() {
		return description;
	}

	public final int getIdUser() {
		return idUser;
	}

	public final int getIdDiscussion() {
		return id;
	}

	public final Category getCategory() {
		return category;
	}

	public final Date getData() {
		return data;
	}

	public final String toString() {
		return "\nID=  " + getIdUser() + "\t TITLE= " + getTitle() + "\nDESCRIPTION:\n" + getDescription();
	}

}
