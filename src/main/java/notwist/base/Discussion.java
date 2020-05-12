package notwist.base;

public interface Discussion {

	public String getTitle();
	
	public String getDescription();
	
	public int getIdUser();
	
	public Category getCategory();
	
	@Override
	public String toString();

}
