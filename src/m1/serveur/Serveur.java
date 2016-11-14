package m1.serveur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

import m1.SQLRequest.SQLRequest;
import m1.clearanceRequest.ClearanceRequest;
import m1.connectionManager.ConnectionManager;
import m1.dataBase.DataBase;
import m1.securityManager.SecurityManager;
import m1.securityQuery.SecurityQuery;
import m1.vueglobale.ServeurGServeurBind;
import m2.composant.ComposantSimple;
import m2.configuration.Attachement;
import m2.configuration.Configuration;
import m2.configuration.PortFourni;
import m2.configuration.PortRequis;
import m2.connecteur.Connecteur;
import m2.connecteur.RoleFrom;

public class Serveur extends Configuration{

	public Serveur() {
		super("Serveur");
		this.addAllPfournis((Arrays.asList(
				new ExternalSocketSecurityCheckRequest(),
				new ClientQueryRequest(),
				new ServeurToServeurGRequest())
				));
		this.addAllPrequis((Arrays.asList(
				new ExternalSocketSecurityCheckResponse(),
				new ClientQueryResponse(),
				new ServeurToServeurGResponse())
				));
	
		
		this.addAllCompos((Arrays.asList(
				new ConnectionManager(),
				new DataBase(),
				new SecurityManager())
				));
		this.addAllConnects((Arrays.asList(
				new ClearanceRequest(),
				new SQLRequest(),
				new SecurityQuery())
				));
		
		ServeurConnectionManagerBind SCMB = new ServeurConnectionManagerBind(pfournis.get(0),((ComposantSimple) compos.get(0)).getPortFourni("ExternalSocketSecurityRequest"), prequis.get(0),((ComposantSimple) compos.get(0)).getPortRequis("ExternalSocketSecurityRequestResponse"));	
		this.bindings.add(SCMB);
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		@SuppressWarnings("unchecked")
		ArrayList<String> portMsg = (ArrayList<String>)arg;
		String nomPort = portMsg.get(0);
		String msg = portMsg.get(1);
		
		if(o instanceof ComposantSimple ){
			RoleFrom rolef = null;
			for(Attachement each : this.attachements){
				if(each.getPortF().getName() == nomPort){
					rolef = each.getRoleFrom();
				}
			}
			for(Connecteur each : this.connects){
				if (each.getRoleFrom(rolef.getName())!=null){
					each.recevoir(msg, rolef);
				}
			}
			
		}else if(o instanceof Connecteur){
			
			m2.composant.PortRequis portR = null;
			for(Attachement each : this.attachements){
				if(each.getPortF().getName() == nomPort){
					portR = each.getPortR();
				}
			}
			for(ComposantSimple each : this.compos){
				if (each.getPortRequis(portR.getName())!=null){
					each.recevoir(msg, portR);
				}
			}
			
		}
		
	}

	@Override
	public void recevoir(Object msg, PortRequis pr) {
		
		
	}

	@Override
	public void envoyer(Object msg, PortFourni pf) {
		List<Object> res = new ArrayList<Object>();
		res.add(pf.getName());
		res.add(msg);
		notifyObservers(res);

		
	}
	
	


	
	

}
