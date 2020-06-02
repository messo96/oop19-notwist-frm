package notwist.base;

public interface Discussion {

	public String getTitle();
	
	public String getDescription();
	
	public int getIdUser();
	
	public int getIdDiscussion();
	
	public Category getCategory();
	
	@Override
	public String toString();

}
