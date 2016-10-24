package connecteur;

public abstract class RoleFrom implements InterfaceConnecteur{
	private String name;
	public RoleFrom(String n){
		name=n;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String s){
		name=s;
	}
}
