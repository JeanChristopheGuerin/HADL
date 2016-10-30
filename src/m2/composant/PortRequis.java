package m2.composant;

public abstract class PortRequis implements InterfaceComp {
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
