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
	public void envoyer(Object msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object recevoir() {
		// TODO Auto-generated method stub
		return null;
	}

}
