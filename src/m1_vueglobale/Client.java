package m1_vueglobale;
import java.util.ArrayList;
import java.util.List;

import composant.ComposantSimple;
import composant.PortFourni;

public class Client extends ComposantSimple{

	protected Client() {
		super("Client");
		Send_Request SR = new Send_Request();
		Send_Request_Response SRR = new Send_Request_Response();
		this.pfournis.add(SR);
		this.prequis.add(SRR);
	}

	@Override
	protected void envoi(Object msg, PortFourni pf) {
		List<Object> res = new ArrayList<Object>();
		res.add(pf.getName());
		res.add(msg);
		notifyObservers(res);
		
	}
	

}
