package m2.composant;

public abstract class PortFourni implements InterfaceComp {
	public String name;
	
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
