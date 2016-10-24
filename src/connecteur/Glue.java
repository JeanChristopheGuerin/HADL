package connecteur;

import composant.InterfaceComp;
import composant.PortFourni;
import composant.PortRequis;

public abstract class Glue {
	private InterfaceComp port;
	private InterfaceConnecteur role;
	Glue(PortFourni pF, RoleFrom rF){
		port = pF;
		role = rF;
	}
	Glue(PortRequis pR, RoleTo rT){
	port = pR;
		role = rT;
	}
	 abstract void actionColler();
}
