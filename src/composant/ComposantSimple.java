package composant;

import java.util.ArrayList;
import java.util.List;




import composantG.ComposantG;

public abstract class ComposantSimple extends ComposantG{
	protected List<PortRequis> prequis = new ArrayList<PortRequis>();
	protected List<PortFourni> pfournis = new ArrayList<PortFourni>();
	
	protected ComposantSimple(String nom){
		this.nom = nom;
	}
	public PortRequis getPortRequis(String n){
		for (PortRequis each:prequis){
			if (each.getName()==n){
				return each;
			}
		
		}
		System.out.println("Element introuvable");
		return null;
		
	}
	public PortFourni getPortFourni(String n){
		for (PortFourni each:pfournis){
			if (each.getName()==n){
				return each;
			}
		
		}
		System.out.println("Element introuvable");
		return null;
		
	}
	abstract protected void envoi(Object msg,PortFourni pf);
}
