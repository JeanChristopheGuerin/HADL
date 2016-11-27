package m1.vueglobale;

import m2.configuration.PortFourni;
import m2.configuration.PortRequis;
import m2.configuration.Attachement;

import m2.connecteur.RoleFrom;
import m2.connecteur.RoleTo;

public class ServeurRPC extends Attachement{

	protected ServeurRPC(PortFourni pF, PortRequis pR, RoleFrom rF,
			RoleTo rT) {
		super("ServeurRPC", pF, pR, rF, rT);
	}

	

	

}
