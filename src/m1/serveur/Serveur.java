package m1.serveur;

import java.util.Arrays;
import java.util.Observable;

import m1.SQLRequest.SQLRequest;
import m1.clearanceRequest.ClearanceRequest;
import m1.connectionManager.ConnectionManager;
import m1.dataBase.DataBase;
import m1.securityManager.SecurityManager;
import m1.securityQuery.SecurityQuery;
import m1.vueglobale.ServeurGServeurBind;
import m2.composant.ComposantSimple;
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
				new DataBase(),
				new SecurityManager())
				);
		this.connects.addAll(Arrays.asList(
				new ClearanceRequest(),
				new SQLRequest(),
				new SecurityQuery()
				));
		
		ServeurConnectionManagerBind SCMB = new ServeurConnectionManagerBind(pfournis.get(0),((ComposantSimple) compos.get(0)).getPortFourni("ExternalSocketSecurityRequest"), prequis.get(0),((ComposantSimple) compos.get(0)).getPortRequis("ExternalSocketSecurityRequestResponse"));	
		this.bindings.add(SCMB);
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
