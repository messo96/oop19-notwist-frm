package notwist.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Class for manage interaction with database from Users
 */
public class DBUser extends DBManagerImpl {

	private ResultSet rs = null;
    private String query;
    
    /**
	 * 
	 * @param user
	 * 			verify that user effectively is registered
	 * @return
	 * 			true if it is registered, false otherwise
	 */
	public boolean existUser(String email) {
		
		try
		{
			String query = "select * from USER ";
			rs = open().executeQuery(query);
			while(rs.next()) {
				if(rs.getString("email").contentEquals(email)) {
				System.out.println("User exist! (" + email + ")");
					return true;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("User doesn't exist!"+e);
		}
		finally {
			close();
		}

		return false;
	}
	

	/**
	 * 
	 * @param user
	 * 				name of the account
	 * @param password
	 *				encrypted password
	 * @param email
	 * 				a valid email
	 * @param isModerator
	 * 				if the account has the privileges of moderator
	 * @return
	 * 			true if account has been saved successfully, false otherwise
	 */
	public boolean addUser(String user, String password, String email, boolean isModerator) {
	     if(existUser(user))
	    	 return false;
	     
	     int index=0;
	     try {
			 query = "select * from USER";
		     rs = open().executeQuery(query);
		     
		     while(rs.next())
		    	 index = rs.getInt("id_user");
		     
		        PreparedStatement prepared = super.getConn()
		        		.prepareStatement("insert into USER (id_user,nome, password, email,isModeratore) values (?,?,?,?,?)");
		     	prepared.setInt(1, index+1);
		        prepared.setString(2, this.Crypt(user));
		     	prepared.setString(3, this.Crypt(password));
		     	prepared.setString(4,this.Crypt(email));
		     	prepared.setBoolean(5, isModerator);
		     	
		     	prepared.executeUpdate();
		     	return true;
		}
		catch(Exception e) {
			System.out.println("\nError while adding new user " + e);
			return false;
		}
		finally {
			close();
		}
	}
	
	
	public User login(String email, String password) {
		
		if(!this.existUser(email))
			return null;
		
		User user = null;
		open();
		try
		{
			query = "select * from USER ";
			rs = open().executeQuery(query);
			while(rs.next()) {
				if(rs.getString("email").contentEquals(email) && rs.getString("password").contentEquals(password)) {
					user = new User(rs.getInt("id_user"), this.Decrypt(rs.getString("nome")),this.Decrypt(rs.getString("password"))
							,this.Decrypt(rs.getString("email")),rs.getBoolean("isModeratore"));
					System.out.println("Welcome " + user.getName()+ " :)");
					
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("User doesn't exist!"+e);
			
		}
		finally {
			close();
		}
		
		return user;
	}
	
	
	
}
