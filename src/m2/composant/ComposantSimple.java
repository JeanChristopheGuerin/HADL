package m2.composant;

import java.util.ArrayList;
import java.util.List;

import m2.composantG.ComposantG;

public abstract class ComposantSimple extends ComposantG{
	protected List<PortRequis> prequis = new ArrayList<PortRequis>();
	protected List<PortFourni> pfournis = new ArrayList<PortFourni>();
	
	public ComposantSimple(String nom){
		this.nom = nom;
	}
	public PortRequis getPortRequis(String n){
		for (PortRequis each:prequis){
			if (each.getName()==n){
				return each;
			}
		
		}
		System.out.println("Port Requis introuvable dans "+ nom);
		return null;
		
	}
	public PortFourni getPortFourni(String n){
		for (PortFourni each:pfournis){
			if (each.getName()==n){
				return each;
			}
		
		}
		System.out.println("Port Fourni introuvable dans "+ nom);
		return null;
		
	}
	 public abstract void envoi(Object msg,PortFourni pf);
	public abstract void recevoir(Object msg, PortRequis portR);
	public abstract void recevoir(String msg, m2.composant.PortFourni pf);

}
