package configuration;

public abstract class PortFourni {
	private String name;
	public PortFourni(String n){
		name=n;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String s){
		name=s;
	}
}
