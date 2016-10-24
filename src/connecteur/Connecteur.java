package connecteur;

import java.util.ArrayList;
import java.util.List;

import composant.PortFourni;
import composant.PortRequis;
import composantG.ComposantG;

public abstract class Connecteur extends ComposantG {
	protected List<RoleFrom> rfrom = new ArrayList<RoleFrom>();
	protected List<RoleTo> rto = new ArrayList<RoleTo>();
	protected Glue glue;
	
	protected Connecteur(String nom){
		this.nom = nom;
	}
	public RoleFrom getRoleFrom(String n){
		for (RoleFrom each:rfrom){
			if (each.getName()==n){
				return each;
			}
		
		}
		System.out.println("Element introuvable");
		return null;
		
	}
	public RoleTo getRoleTo(String n){
		for (RoleTo each:rto){
			if (each.getName()==n){
				return each;
			}
		
		}
		System.out.println("Element introuvable");
		return null;
		
	}
	public abstract void recevoir(Object o,RoleFrom rf);

}
