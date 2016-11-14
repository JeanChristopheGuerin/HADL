package m1.vueglobale;
import java.util.ArrayList;
import java.util.List;

import m2.composant.ComposantSimple;
import m2.composant.PortFourni;
import m2.composant.PortRequis;

public class Client extends ComposantSimple{

	public Client() {
		super("Client");
		Send_Request SR = new Send_Request();
		Send_Request_Response SRR = new Send_Request_Response();
		this.pfournis.add(SR);
		this.prequis.add(SRR);
	}

	@Override
	public void envoi(Object msg, PortFourni pf) {
		List<Object> res = new ArrayList<Object>();
		res.add(pf.getName());
		res.add(msg);
		notifyObservers(res);
		System.out.println( this.nom+" sending "+ msg +" to " +pf.getName());
		
	}

	@Override
	public void recevoir(String msg, PortRequis portR) {
		// TODO Auto-generated method stub
		
	}
	

}
