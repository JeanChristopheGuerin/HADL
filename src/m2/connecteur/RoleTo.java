package m2.connecteur;

public abstract class RoleTo implements InterfaceConnecteur{
	private String name;
	public RoleTo(String n){
		name=n;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String s){
		name=s;
	}
}
