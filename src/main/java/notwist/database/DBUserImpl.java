package notwist.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

/**
 * Class for manage interaction with database from Users
 */
public class DBUserImpl extends DBManagerImpl implements DBUser {

	private ResultSet rs = null;
    private String query;
    
   //cambiare ed ottimizzare query con Relax
	public boolean existUser(final String email) {
		
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

	public boolean register(final String user, final String password, final String email, final boolean isModerator) {
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
		        prepared.setString(2, user);
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
	
	//cambiare ed ottimizzare query con Relax
	public Optional<User> login(final String email, final String password) {
		
		User user = null;
		try
		{
			query = "select * from USER ";
			rs = open().executeQuery(query);
			while(rs.next()) {
				if(rs.getString("email").contentEquals(this.Crypt(email)) && rs.getString("password").contentEquals(this.Crypt(password))) {
					user = new User(rs.getInt("id_user"), rs.getString("nome"),this.Decrypt(rs.getString("password"))
							,this.Decrypt(rs.getString("email")),rs.getBoolean("isModeratore"));
					System.out.println("Welcome " +user.getName() +" \t:)");	
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("User doesn't exist!\n"+e);
			
		}
		finally {
			close();
		}
		if(user != null)
			return Optional.of(user);
		else
			return Optional.empty();
		
	}
	
	
	
}
