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
import m2.configuration.Binding;
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
		
		ServeurConnectionManagerBind SCMB = new ServeurConnectionManagerBind(pfournis.get(0),((ComposantSimple) compos.get(0)).getPortFourni("ExternalSocketSecurityRequest"), prequis.get(0),((ComposantSimple) compos.get(0)).getPortRequis("ExternalSocketSecurityResponse"));	
		this.bindings.add(SCMB);
		
		SQLRequestTODatabase SQLTDB = new SQLRequestTODatabase(((ComposantSimple) compos.get(1)).getPortFourni("QueryInterrogationRequest"),((ComposantSimple) compos.get(1)).getPortRequis("QueryInterrogationResponse"),((Connecteur) connects.get(1)).getRoleFrom("Called2SQLRequest"),((Connecteur) connects.get(1)).getRoleTo("Caller2SQLRequest"));
		SQLRequestTOConnectionManager SQLTCM = new SQLRequestTOConnectionManager(((ComposantSimple) compos.get(0)).getPortFourni("DBQueryRequest"),((ComposantSimple) compos.get(0)).getPortRequis("DBQueryResponse"),((Connecteur) connects.get(1)).getRoleFrom("CalledSQLRequest"),((Connecteur) connects.get(1)).getRoleTo("CallerSQLRequest"));
		this.attachements.add(SQLTDB);
		this.attachements.add(SQLTCM);
		
		//SQLRequestTODatabase SQL = new SQLRequestTODatabase(((ComposantSimple) compos.get(1)).getPortFourni("QueryInterrogationRequest"),((ComposantSimple) compos.get(1)).getPortRequis("QueryInterrogationResponse"),((Connecteur) connects.get(1)).getRoleFrom("Called"),((Connecteur) connects.get(1)).getRoleTo("Caller"));

		
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
	
						rolef = each.getRoleFrom();
						
					}
				}
			}
			
			////Sinon c'est vers une configuration
			if (rolef == null)
			for(Binding each: this.bindings){
				if(each.getPortRComp().getName() == nomPort){
					
					portFConf = each.getPortF();
					
				}else if(each.getPortFComp().getName() == nomPort){
					
					portRConf = each.getPortR();
				}
			}
			
			///// On envoie vers le connecteur ou la configuration
			//Vers le connecteur
			if (rolef != null){ 
				
				for(Connecteur each : this.connects){
					if (each.getRoleFrom(rolef.getName())!=null){
						System.out.println("envoi "+msg +" au connecteur"+ each.nom);
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
					if (each.getPortRequis(portRConf.getName()) != null){
						each.recevoir(msg, portRConf);
					}
				}
			}
			else{
				System.out.println("Probleme envoie vers port qui n'est reli� � rien ");
			}
			
		/////////////////////////////// Un connecteur notifie l'observer	
		}else if(o instanceof Connecteur){
			
			m2.composant.PortRequis portR = null;
			m2.configuration.PortRequis portRConf = null;
			
			///On regarde si c'est vers un composant simple
			for(Attachement each : this.attachements){
				if(each.getRoleTo() != null){
					
					if(each.getRoleTo().getName() == nomPort){
						
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
				System.out.println("Probleme envoie vers port qui n'est reli� � rien");
			}
			
		/////////////////////////////// Une configuration notifie l'observer	
		}else if(o instanceof Configuration){
			
			m2.composant.PortFourni pf = null;
			m2.composant.PortRequis pr = null;
			m2.configuration.PortFourni pfConf = null;
			m2.configuration.PortRequis prConf = null;
			
			////On regarde si �a va vers un comosant
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
			////Sinon �a va vers une configuration
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
		System.out.println("Message "+ (String)msg +" recu sur "+this.getNom()+" sur le port "+ pr.getName());
		
		//On sait sur quel port envoyer le msg pour le server
		m2.composant.PortFourni pfComp = null;
		for(Binding each : this.bindings){
			
			if(each.getPortF().getName() == "ExternalSocketSecurityCheckRequest"){
				pfComp = each.getPortFComp();
				
			}
		}
		
		for(ComposantSimple each : this.compos){
			
			if(each.getPortFourni(pfComp.getName()) != null){
				System.out.println(this.nom+" sending "+ msg +" to " +pfComp.getName());
				each.recevoir(msg, pfComp);
			}
		}
		
	}

	@Override
	public void envoyer(Object msg, PortFourni pf) {
		List<Object> res = new ArrayList<Object>();
		res.add(pf.getName());
		res.add(msg);
		notifyObservers(res);

		
	}

	@Override
	public void recevoir(Object msg, PortFourni pf) {
		System.out.println("Message "+ (String)msg +" recu sur "+this.getNom()+" sur le port "+ pf.getName());
		
		//On sait sur quel port envoyer le msg pour le server
				m2.composant.PortRequis prComp = null;
				for(Binding each : this.bindings){
					
					if(each.getPortR().getName() == "ExternalSocketSecurityCheckRequest"){
						prComp = each.getPortRComp();
					}
				}
				
				for(ComposantSimple each : this.compos){
					
					if(each.getPortRequis(prComp.getName()) != null){
						System.out.println(this.nom+" sending "+ msg +" to " +prComp.getName());
						
						//each.recevoir(msg, prComp);
					}
				}
		
	}

	@Override
	public void envoyer(Object msg, PortRequis pr) {
		List<Object> res = new ArrayList<Object>();
		res.add(pr.getName());
		res.add(msg);
		notifyObservers(res);
		
	}

	@Override
	public void recevoir(Object msg, m2.composant.PortRequis pr) {
		if(pr.getName()=="ExternalSocketSecurityCheckResponse"){
			envoyer(msg,this.prequis.get(1));
			System.out.println("Reception de" + (String)msg);
		}
		
	}

	@Override
	public void recevoir(Object msg, m2.composant.PortFourni portFConf) {
		// TODO Auto-generated method stub
		
	}
	
	


	
	

}
