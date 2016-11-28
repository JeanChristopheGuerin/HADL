package m1.connectionManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import m2.composant.ComposantSimple;
import m2.composant.PortFourni;
import m2.composant.PortRequis;

public class ConnectionManager extends ComposantSimple {

	public ConnectionManager() {
		super("ConnectionManager");
		this.pfournis.addAll(Arrays.asList(new DBQueryRequest(),
				new ExternalSocketSecurityRequest(),
				new SecurityCheckRequest()
				)
				);
		this.prequis.addAll(Arrays.asList(new DBQueryResponse(),
				new ExternalSocketSecurityResponse(),
				new SecurityCheckResponse())
				
				);
		
	}

	@Override
	public void envoi(Object msg, PortFourni pf) {
		
		List<Object> res = new ArrayList<Object>();
		res.add(pf.getName());
		res.add(msg);
		System.out.println(this.nom+" sending "+ msg +" to " +pf.getName());
		
		setChanged();
		notifyObservers((Object)res);
		
		
		
	}

	@Override
	public void recevoir(Object msg, PortRequis portR) {
		 if(portR.getName() == "DBQueryResponse"){
			System.out.println("Message "+ (String)msg +" recu sur "+this.getNom()+" sur le port "+ portR.getName());
			envoi(msg,prequis.get(1));
			
			
		 }/*else if(portR.getName() == "ExternalSocketSecurityResponse"){
				System.out.println("Message "+ (String)msg +" recu sur "+this.getNom()+" sur le port "+ portR.getName());
				envoi(msg,pfournis.get(1));
		
		 }*/
	}

	public void envoi(Object msg, PortRequis pr) {
		
		List<Object> res = new ArrayList<Object>();
		res.add(pr.getName());
		res.add(msg);
		System.out.println(this.nom+" sending "+ msg +" to " +pr.getName());
		
		setChanged();
		notifyObservers((Object)res);
		
		
		
	}

	@Override
	public void recevoir(Object msg, PortFourni prComp) {
		if(prComp.getName() == "ExternalSocketSecurityRequest"){
			System.out.println("Message "+ (String)msg +" recu sur "+this.getNom()+" sur le port "+ prComp.getName());
			if((String)msg != "connect"){
				envoi(msg,pfournis.get(0));
			}
		}
			
		
		
	}

}
