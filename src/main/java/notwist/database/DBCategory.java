package notwist.database;

import java.util.List;
import java.util.Optional;
import notwist.base.Category;


public interface DBCategory {

	  
		public Optional<List<Category>> getCategories();

		
		public boolean existCategory(String name);
		/**
		 * NON mi piace ma è per far vedere nella lista della HomePage
		 * @return
		 */
		public Optional< List<Category> > getNameOfAllTheCategories();
		
		public Category getCategoryByName(final String name);
		
		public Category getCategoryById(final Integer id);

}
