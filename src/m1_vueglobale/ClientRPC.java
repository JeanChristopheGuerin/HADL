package m1_vueglobale;

import configuration.Attachement;
import composant.PortFourni;
import composant.PortRequis;
import connecteur.RoleFrom;
import connecteur.RoleTo;

public class ClientRPC extends Attachement{

	public ClientRPC(PortFourni pF, PortRequis pR, RoleFrom rF, RoleTo rT) {
		super("ClientRPC", pF, pR, rF, rT);
		
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
