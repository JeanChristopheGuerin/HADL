package m2.connecteur;

import m2.composant.InterfaceComp;
import m2.composant.PortFourni;
import m2.composant.PortRequis;

public abstract class Glue {
	private InterfaceComp port;
	private InterfaceConnecteur role;
	//TODO changer les constructeur (glue pas connaissance des ports)
	public Glue(PortFourni pF, RoleFrom rF){
		port = pF;
		role = rF;
	}
	public Glue(PortRequis pR, RoleTo rT){
		port = pR;
		role = rT;
	}
	public abstract void actionColler();
}
