package m1.vueglobale;
import java.util.ArrayList;
import java.util.List;

import m2.connecteur.Connecteur;
import m2.connecteur.RoleFrom;
public class RPC extends Connecteur{

	RPC() {
		super("RPC");
		this.rfrom.add(new RPC_RoleFrom());
		this.rto.add(new RPC_RoleTo());
	}

	@Override
	public void recevoir(Object o, RoleFrom rf) {
		//TODO comprendre la signification de �a
		/*List<Object> res = new ArrayList<Object>();
		res.add(rf.getName());
		res.add(msg);
		notifyObservers(res);*/
		
	}

}