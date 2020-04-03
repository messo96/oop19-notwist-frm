package notwist.database;

public class User {

	private Integer id;
	private String name;
	private String surname;
	private String email;
	private boolean isModerator;
	
	public User(Integer id,String name,String surname,String email,boolean isMod) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.isModerator = isMod;
	}

	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public boolean isModerator() {
		return isModerator;
	}
	
	
	
}
