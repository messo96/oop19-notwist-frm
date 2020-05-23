package notwist.base;

import java.util.Date;

public class DiscussionImpl implements Discussion{
	private int idUser;
	private String title;
	private String description;
	private Category category;
	private Date data;
	//maybe add List of comments ? Ask rombo for comments class
	

	public DiscussionImpl(Integer id,String title, String description, Category category, Date data) {
		this.idUser = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.data = data;
	}
	
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	
	public int getIdUser() {
		return idUser;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public Date getData() {
		return data;
	}
	

	public String toString() {
		return "\nID=  " + getIdUser() + "\t TITLE= "+ getTitle() + "\nDESCRIPTION:\n" + getDescription();
	}

}
