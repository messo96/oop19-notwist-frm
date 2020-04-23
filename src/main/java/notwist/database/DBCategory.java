package notwist.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import notwist.base.Category;
import notwist.base.CategoryImpl;

public class DBCategory {
	private DBManagerImpl database = new DBManagerImpl();
	private ResultSet rs = null;
    private String query;
    
    
	public Optional<List<Category>> getCategories(){
		List<Category> list = new ArrayList<>();
		query = "Select * from TOPIC";
	    
		try {
			rs = database.open().executeQuery(query);
			while(rs.next()) {
				list.add(new CategoryImpl(rs.getInt("id_macro"),rs.getString("titolo")));
			}
					
		}
		catch(Exception e) {
			System.out.println("Error while loading categories");
		}
		finally {
			database.close();
		}
		return Optional.of(list);
	}

	
	public boolean existCategory(String name){
		query = "Select * from TOPIC";
	    boolean flag=false;
		try {
			rs = database.open().executeQuery(query);
			while(rs.next()) {
				if(rs.getString("titolo").contentEquals(name)) {
					flag = true;
					break;	
				}
				
			}					
		}
		catch(Exception e) {
			System.out.println("Error looking for category " + name);
		}
		finally {
			database.close();
		}
		return flag;
	}

	/**
	 * NON mi piace ma è per far vedere nella lista della HomePage
	 * @return
	 */
	public Optional< List<Category> > getNameOfAllTheCategories() {
		
			List<Category> list = new ArrayList<>();
			query = "Select * from TOPIC";
			try {
				rs = database.open().executeQuery(query);
				while(rs.next()) {
					list.add(new CategoryImpl(rs.getInt("id_macro"),rs.getString("titolo")));
				}
				return Optional.of(list);
			}
			catch(Exception e) {
				System.out.println("Error String[] categories");
			}
			finally {
				database.close();
			}
			return Optional.of(list);
		}
	
	public Category getCategoryByName(final String name) {
		return this.getNameOfAllTheCategories().get().stream().filter(c -> c.getName().equals(name)).findFirst().get();
	}
	
	public Category getCategoryById(final Integer id) {
		return this.getNameOfAllTheCategories().get().stream().filter(c -> c.getId() == id).findFirst().get();
	}
}