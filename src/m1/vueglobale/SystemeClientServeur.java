package m1.vueglobale;
import java.util.ArrayList;
import java.util.Observable;

import m2.composant.ComposantSimple;
import m2.composant.PortFourni;
import m2.composant.PortRequis;
import m2.configuration.Attachement;
import m2.configuration.Configuration;
import m2.connecteur.Connecteur;
import m2.connecteur.RoleFrom;

public class SystemeClientServeur extends Configuration{

	SystemeClientServeur() {
		super("SystemeClientServeur");
		this.compos.add(new Client());
		this.compos.add(new ServeurG());
		this.pfournis.add(new Systeme_PF());
		this.connects.add(new RPC());
		
		ClientRPC CRPC = new ClientRPC(((ComposantSimple) compos.get(0)).getPortFourni("Send_Request"), ((ComposantSimple) compos.get(0)).getPortRequis("Send_Request_Response") , connects.get(0).getRoleFrom("RPC_RoleFrom"), connects.get(0).getRoleTo("RPC_RoleTo"));
		this.attachements.add(CRPC);
		
		ServeurRPC SRPC = new ServeurRPC(((ComposantSimple) compos.get(1)).getPortFourni("Receive_Request_Response"), ((ComposantSimple) compos.get(1)).getPortRequis("Receive_Request") , connects.get(0).getRoleFrom("RPC_RoleFrom"), connects.get(0).getRoleTo("RPC_RoleTo"));
		this.attachements.add(CRPC);
		
		SystemeClientBind SCB = new SystemeClientBind(pfournis.get(0), ((ComposantSimple) compos.get(0)).getPortFourni("Send_Request"), (m2.configuration.PortRequis)null, (m2.composant.PortRequis)null);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof ComposantSimple ){
			@SuppressWarnings("unchecked")
			ArrayList<String> portMsg = (ArrayList<String>)arg;
			String nomPort = portMsg.get(0);
			Object msg = portMsg.get(1);
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
			
		}else if(o instanceof Configuration){
			
		}
		
	}
	
	
}