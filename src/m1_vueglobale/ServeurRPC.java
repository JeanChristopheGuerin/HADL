package m1_vueglobale;

import composant.PortFourni;
import composant.PortRequis;

import configuration.Attachement;
import connecteur.RoleFrom;
import connecteur.RoleTo;

public class ServeurRPC extends Attachement{

	protected ServeurRPC(PortFourni pF, PortRequis pR, RoleFrom rF,
			RoleTo rT) {
		super("ServeurRPC", pF, pR, rF, rT);
	}

	@Override
	protected void Envoyer() {
		
	}

	@Override
	protected void Recevoir() {
		
	}

}
