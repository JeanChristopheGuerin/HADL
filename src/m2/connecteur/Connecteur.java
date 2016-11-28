package m2.connecteur;

import java.util.ArrayList;
import java.util.List;

import m2.composantG.ComposantG;
//TODO ajouter la fonction envoyer()
public abstract class Connecteur extends ComposantG {
	
	protected List<RoleFrom> rfrom = new ArrayList<RoleFrom>();
	protected List<RoleTo> rto = new ArrayList<RoleTo>();
	protected Glue glue;
	
	public Connecteur(String nom){
		this.nom = nom;
	}
	public RoleFrom getRoleFrom(String n){
		for (RoleFrom each:rfrom){
			if (each.getName()==n){
				return each;
			}
		
		}

		return null;
		
	}
	public RoleTo getRoleTo(String n){
		for (RoleTo each:rto){
			if (each.getName()==n){
				return each;
			}
		
		}

		return null;
		
	}
	
	public Glue getGlue() {
		return glue;
	}
	public void setGlue(Glue glue) {
		this.glue = glue;
	}
	
	public abstract void recevoir(Object o,RoleFrom rf);
	public abstract void envoyer(Object o, RoleTo rt);
}
