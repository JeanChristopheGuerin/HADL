package m1.vueglobale;
import java.util.Observable;

import m1.serveur.Serveur;
import m2.composant.PortFourni;
import m2.composant.PortRequis;
import m2.configuration.Configuration;

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
