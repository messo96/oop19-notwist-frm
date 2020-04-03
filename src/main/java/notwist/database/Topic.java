package notwist.database;

public class Topic {

	private int id;
	private int id_user;
	private String title;
	private String description;
	
	public Topic(int id, int id_user, String title, String description) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.title = title;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public int getId_user() {
		return id_user;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
	
	
	
}
