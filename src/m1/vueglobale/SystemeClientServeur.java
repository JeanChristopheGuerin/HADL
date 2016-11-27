package m1.vueglobale;
import java.util.ArrayList;
import java.util.Observable;

import m2.composant.ComposantSimple;
import m2.configuration.Attachement;
import m2.configuration.Binding;
import m2.configuration.Configuration;
import m2.configuration.PortFourni;
import m2.configuration.PortRequis;
import m2.connecteur.Connecteur;
import m2.connecteur.RoleFrom;

public class SystemeClientServeur extends Configuration{

	public SystemeClientServeur() {
		super("SystemeClientServeur");
		
	
		this.addCompos(new Client());
		this.addConf(new ServeurG());
		this.addPfournis(new Systeme_PF());
		this.addConnects(new RPC());
		
		ClientRPC CRPC = new ClientRPC(((ComposantSimple) compos.get(0)).getPortFourni("Send_Request"), ((ComposantSimple) compos.get(0)).getPortRequis("Send_Request_Response") , connects.get(0).getRoleFrom("RPC_RoleFrom"), connects.get(0).getRoleTo("RPC_RoleTo"));
		this.attachements.add(CRPC);
		
		ServeurRPC SRPC = new ServeurRPC( conf.get(0).getPortFourni("Receive_Request_Response"),  conf.get(0).getPortRequis("Receive_Request") , connects.get(0).getRoleFrom("RPC_RoleFrom"), connects.get(0).getRoleTo("RPC_RoleTo"));
		this.attachements.add(SRPC);
		
		SystemeClientBind SCB = new SystemeClientBind(pfournis.get(0), ((ComposantSimple) compos.get(0)).getPortFourni("Send_Request"), (m2.configuration.PortRequis)null, (m2.composant.PortRequis)null);
		this.bindings.add(SCB);
	}

	@Override
	public void update(Observable o, Object arg) {
		@SuppressWarnings("unchecked")
		ArrayList<String> portMsg = (ArrayList<String>)arg;
		String nomPort = portMsg.get(0);
		String msg = portMsg.get(1);
		
		/////////////////////////////// Un composant notifie l'observer
		/////On regarde si c'est vers un connecteur
		if(o instanceof ComposantSimple ){
			RoleFrom rolef = null;
			m2.configuration.PortFourni portFConf = null;
			m2.configuration.PortRequis portRConf = null;
			System.out.println("L'objet est un composant simple");
			/////On regarde si c'est vers un connecteur
			for(Attachement each : this.attachements){
				if(each.getPortF() != null){
					if(each.getPortF().getName() == nomPort){
						
						System.out.println("envoi "+msg +" au connecteur"+ each.nom);
						rolef = each.getRoleFrom();
					}
				}
			}
			
			////Sinon c'est vers une configuration
			if (rolef == null)
			for(Binding each: this.bindings){
				if(each.getPortRComp().getName() == nomPort){
					portFConf = each.getPortF();
				}else if(each.getPortRComp().getName() == nomPort){
					portRConf = each.getPortR();
				}
			}
			
			///// On envoie vers le connecteur ou la configuration
			//Vers le connecteur
			if (rolef != null){ 
				
				for(Connecteur each : this.connects){
					if (each.getRoleFrom(rolef.getName())!=null){
						System.out.println(each.getNom());
						each.recevoir(msg, rolef);
						
					}
				}
			}
			//Vers le port fourni d'une configuration
			else if(portFConf != null){
				for(Configuration each : this.conf){
					if (each.getPortFourni(portFConf.getName()) != null){
						each.recevoir(msg, portFConf);
					}
				}
			}
			//Vers le port requis d'une configuration
			else if(portRConf != null){
				for(Configuration each : this.conf){
					if (each.getPortFourni(portRConf.getName()) != null){
						each.recevoir(msg, portRConf);
					}
				}
			}
			else{
				System.out.println("Probleme envoie vers port qui n'est relié à rien ");
			}
			
		/////////////////////////////// Un connecteur notifie l'observer	
		}else if(o instanceof Connecteur){
			System.out.println("L'objet est un connecteur");
			m2.composant.PortRequis portR = null;
			m2.configuration.PortRequis portRConf = null;
			///On regarde si c'est vers un composant simple
			for(Attachement each : this.attachements){
				if(each.getPortF() != null){
					if(each.getPortF().getName() == nomPort){
						portR = each.getPortR();
					}
				}
				
			}
			///On regarde si c'est vers une configuration
			if (portR == null){
				
				for(Attachement each : this.attachements){
					if(each.getRoleTo() != null){
						System.out.println(each.getRoleTo().getName());
						if(each.getRoleTo().getName() == nomPort){
							
							portRConf = each.getPortRConf();
						}
					}
					
				}
			}
			
			if (portR != null){
				for(ComposantSimple each : this.compos){
					if (each.getPortRequis(portR.getName())!=null){
						each.recevoir(msg, portR);
					}
				}
			}else if(portRConf != null){
				for(Configuration each : this.conf){
					if (each.getPortRequis(portRConf.getName())!=null){
						each.recevoir(msg, portRConf);
					}
				}
			}else{
				System.out.println("Probleme envoie vers port qui n'est relié à rien");
			}
			
		/////////////////////////////// Une configuration notifie l'observer	
		}else if(o instanceof Configuration){
			System.out.println("L'objet est une config");
			m2.composant.PortFourni pf = null;
			m2.composant.PortRequis pr = null;
			m2.configuration.PortFourni pfConf = null;
			m2.configuration.PortRequis prConf = null;
			
			////On regarde si ça va vers un comosant
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
			////Sinon ça va vers une configuration
			if (pf == null && pr == null){
				for(Binding each : this.bindings){
					if(each.getPortF().getName() == nomPort){
						pfConf = each.getPortFConf2();
					}else if(each.getPortR().getName() == nomPort){
						prConf = each.getPortRConf2();
					}
				}
				if(pfConf != null){
					for(Configuration each : this.conf){
						if (each.getPortFourni(pfConf.getName()) != null){
							each.recevoir(msg, pfConf);
						}
					}
				}else if(prConf != null){
					for(Configuration each : this.conf){
						if (each.getPortRequis(prConf.getName()) != null){
							each.recevoir(msg, prConf);
						}
					}
				}
			}
			
		}
		
	}
	
	@Override
	public void recevoir(Object msg, PortFourni pf) {
		System.out.println("Message "+ (String)msg +" reçut sur le port "+ pf.getName());
	}
	
	@Override
	public void recevoir(Object msg, PortRequis pr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void envoyer(Object msg, PortFourni pf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void envoyer(Object msg, PortRequis pr) {
		// TODO Auto-generated method stub
		
	}
	
	
}
