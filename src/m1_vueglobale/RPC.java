package m1_vueglobale;
import java.util.ArrayList;
import java.util.List;

import connecteur.Connecteur;
import connecteur.RoleFrom;
public class RPC extends Connecteur{

	RPC() {
		super("RPC");
		this.rfrom.add(new RPC_RoleFrom());
		this.rto.add(new RPC_RoleTo());
	}

	@Override
	public void recevoir(Object o, RoleFrom rf) {
		List<Object> res = new ArrayList<Object>();
		res.add(pf.getName());
		res.add(msg);
		notifyObservers(res);
		
	}

}
