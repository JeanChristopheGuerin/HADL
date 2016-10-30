package m1_vueglobale;
import java.util.Observable;

import composant.PortFourni;
import composant.PortRequis;
import configuration.Configuration;
import m1_serveur.Serveur;

public class ServeurG extends Configuration{

	protected ServeurG() {
		super("ServeurG");
	
		this.pfournis.add(new Receive_Request_Response());
		this.prequis.add(new Receive_Request());
		this.compos.add(new Serveur());
	}

	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}



	

}
