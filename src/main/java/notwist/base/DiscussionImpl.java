package notwist.base;

public class DiscussionImpl implements Discussion{
	private int idUser;
	private String title;
	private String description;
	private Category category;
	//maybe add List of comments ? Ask rombo for comments class
	

	public DiscussionImpl(Integer id,String title, String description, Category category) {
		this.idUser = id;
		this.title = title;
		this.description = description;
		this.category = category;
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

	public String toString() {
		return "\nID=  " + getIdUser() + "\t TITLE= "+ getTitle() + "\nDESCRIPTION:\n" + getDescription();
	}

}
