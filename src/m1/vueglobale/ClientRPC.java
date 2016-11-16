package m1.vueglobale;

import m2.composant.PortFourni;
import m2.composant.PortRequis;
import m2.configuration.Attachement;
import m2.connecteur.RoleFrom;
import m2.connecteur.RoleTo;

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
		System.out.println(this.nom + " reçoit un message");
		return null;
	}

}
