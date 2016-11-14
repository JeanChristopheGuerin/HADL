package m1.vueglobale;

import m2.configuration.PortFourni;
import m2.configuration.PortRequis;
import m2.configuration.AttachementConf;
import m2.connecteur.RoleFrom;
import m2.connecteur.RoleTo;

public class ServeurRPC extends AttachementConf{

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
