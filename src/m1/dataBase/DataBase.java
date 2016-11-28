package m1.dataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import m1.securityManager.ConnectionQuery;
import m1.securityManager.ConnectionQueryResponse;
import m1.securityManager.SecurityAuthentification;
import m1.securityManager.SecurityAuthentificationResponse;
import m2.composant.ComposantSimple;
import m2.composant.PortFourni;
import m2.composant.PortRequis;

public class DataBase extends ComposantSimple{
	private Map<String, String> Username= new HashMap<String, String>();
	
	
	
	public DataBase() {
		super("DataBase");
		this.pfournis.addAll(Arrays.asList(new QueryInterrogationRequest(),
				new SecurityManagementRequest())
				);
		this.prequis.addAll(Arrays.asList(new QueryInterrogationResponse(),
				new SecurityManagementResponse())
				);
		this.Username.put("toto", "Reponse positive");
	}

	
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
		System.out.println("Message "+ (String)msg +" recu sur "+this.getNom()+" sur le port "+ portR.getName());
		
		if(Username.containsKey((String)msg)){
			envoi(Username.get((String)msg),pfournis.get(0));
			
		}else {
			System.out.println("Echec de la requete");
		}
		
		
	}



	@Override
	public void recevoir(Object msg, PortFourni prComp) {
		System.out.println("Message "+ (String)msg +" recu sur "+this.getNom()+" sur le port "+ prComp.getName());

		
	}


}
