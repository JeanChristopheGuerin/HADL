package configuration;

public abstract class PortRequis {
	private String name;
	public PortRequis(String n){
		name=n;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String s){
		name=s;
	}
}
