package m1.serveur;

import java.util.Arrays;
import java.util.Observable;

import m1.SQLRequest.SQLRequest;
import m1.connectionManager.ConnectionManager;
import m2.configuration.Configuration;

public class Serveur extends Configuration{

	public Serveur() {
		super("Serveur");
		this.pfournis.addAll(Arrays.asList(
				new ExternalSocketSecurityCheckRequest(),
				new ClientQueryRequest(),
				new ServeurToServeurGRequest())
				);
		this.prequis.addAll(Arrays.asList(
				new ExternalSocketSecurityCheckResponse(),
				new ClientQueryResponse(),
				new ServeurToServeurGResponse())
				);
		this.compos.addAll(Arrays.asList(
				new ConnectionManager(),
				new SQLRequest())
				);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
