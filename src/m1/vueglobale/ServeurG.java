package m1.vueglobale;
import java.util.Observable;

import m1.connectionManager.ConnectionManager;
import m1.dataBase.DataBase;
import m1.securityManager.SecurityManager;
import m1.serveur.Serveur;
import m2.composant.ComposantSimple;
import m2.configuration.Configuration;


public class ServeurG extends Configuration{

	protected ServeurG() {
		super("ServeurG");
		this.conf.add(new Serveur());
		this.pfournis.add(new Receive_Request_Response());
		this.prequis.add(new Receive_Request());
		
		ServeurGServeurBind SSB = new ServeurGServeurBind(pfournis.get(0), ((ComposantSimple) compos.get(0)).getPortFourni("ClientQueryRequest"),prequis.get(0), ((ComposantSimple) compos.get(0)).getPortRequis("ClientQueryResponse")); 
		this.bindings.add(SSB);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	



	

}
