package m1_vueglobale;
import java.util.ArrayList;
import java.util.Observable;

import configuration.Attachement;
import configuration.Configuration;
import connecteur.Connecteur;
import connecteur.RoleFrom;
import composant.ComposantSimple;
import composant.PortFourni;
import composant.PortRequis;

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
		
		SystemeClientBind SCB = new SystemeClientBind(pfournis.get(0), ((ComposantSimple) compos.get(0)).getPortFourni("Send_Request"), (configuration.PortRequis)null, (composant.PortRequis)null);
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
