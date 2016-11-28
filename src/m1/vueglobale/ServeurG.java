package m1.vueglobale;
import java.util.ArrayList;
import java.util.List;
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
		this.pfournis.add(new Receive_Request());
		this.prequis.add(new Receive_Response());
		this.pfournis.add(new Msg_Server_Request());
		this.prequis.add(new Msg_Server_Response());
		
		ServeurGServeurBind SSB = new ServeurGServeurBind(pfournis.get(1),  conf.get(0).getPortFourni("ClientQueryRequest"),prequis.get(1), conf.get(0).getPortRequis("ClientQueryResponse")); 
		this.bindings.add(SSB);

	}

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
	public void recevoir(Object msg, PortRequis pr) {
		System.out.println("Message "+ (String)msg +" reçut sur "+this.getNom()+" sur le port "+ pr.getName());
		
		//On sait sur quel port envoyer le msg pour le server
		m2.configuration.PortRequis prComp = null;
		for(Binding each : this.bindings){
			
			if(each.getPortR().getName() == "Msg_Server_Response"){
				prComp = each.getPortRConf2();
			}
		}
		
		for(Configuration each : this.conf){
			
			if(each.getPortRequis(prComp.getName()) != null){
				System.out.println(this.nom+" sending "+ msg +" to " +prComp.getName());
				each.recevoir(msg, prComp);
			}
		}
		
		//this.compos.get(0).recevoir(msg,this.pfournis.get(0));
	}

	@Override
	public void envoyer(Object msg, PortFourni pf) {
	}

	@Override
	public void recevoir(Object msg, PortFourni pf) {
		
		
	}

	@Override
	public void envoyer(Object msg, PortRequis pr) {
		
		
	}
	



	

}
