package notwist.database;

public class Discussion {
	private int idUser;
	private String title;
	private String description;
	//maybe add List of comments ? Ask rombo for comments class
	
	public Discussion(Integer id,String title, String description) {
		this.idUser = id;
		this.title = title;
		this.description = description;
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
	
	public String toString() {
		return "\nID=  " + getIdUser() + "\t TITLE= "+ getTitle() + "\nDESCRIPTION:\n" + getDescription();
	}

}
