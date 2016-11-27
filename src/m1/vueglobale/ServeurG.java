package m1.vueglobale;
import java.util.ArrayList;
import java.util.Observable;

import m1.serveur.Serveur;
import m2.composant.ComposantSimple;
import m2.configuration.Attachement;
import m2.configuration.Binding;
import m2.configuration.Configuration;
import m2.configuration.PortFourni;
import m2.configuration.PortRequis;
import m2.connecteur.Connecteur;
import m2.connecteur.RoleFrom;


public class ServeurG extends Configuration{

	public ServeurG() {
		super("ServeurG");

		this.conf.add(new Serveur());
		this.pfournis.add(new Receive_Request_Response());
		this.prequis.add(new Receive_Request());
		
		ServeurGServeurBind SSB = new ServeurGServeurBind(pfournis.get(0),  conf.get(0).getPortFourni("ClientQueryRequest"),prequis.get(0), conf.get(0).getPortRequis("ClientQueryResponse")); 
		this.bindings.add(SSB);

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
			
		}else if(o instanceof Configuration){
			System.out.println("test1");
			m2.composant.PortFourni pf = null;
			m2.composant.PortRequis pr = null;
			for(Binding each: this.bindings){
				if(each.getPortF().getName() == nomPort){
					pf = each.getPortFComp();
				}else if(each.getPortR().getName() == nomPort){
					pr = each.getPortRComp();
				}
			}
			if(pf != null){
				for(ComposantSimple each : this.compos){
					if (each.getPortRequis(pf.getName())!=null){
						each.recevoir(msg, pf);
					}
				}
			}else if (pr != null){
				for(ComposantSimple each : this.compos){
					if (each.getPortRequis(pr.getName())!=null){
						each.recevoir(msg, pr);
					}
				}
			}
		}
		
	}

	@Override
	public void recevoir(Object msg, PortRequis pr) {
		System.out.println("Message "+ (String)msg +" reçut sur le port "+ pr.getName());
		
	}

	@Override
	public void envoyer(Object msg, PortFourni pf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recevoir(Object msg, PortFourni pf) {
		System.out.println("Message "+ (String)msg +" reçut sur le port "+ pf.getName());
		
	}

	@Override
	public void envoyer(Object msg, PortRequis pr) {
		// TODO Auto-generated method stub
		
	}
	



	

}
