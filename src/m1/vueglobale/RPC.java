package m1.vueglobale;
import java.util.ArrayList;
import java.util.List;

import m2.connecteur.Connecteur;
import m2.connecteur.RoleFrom;
import m2.connecteur.RoleTo;
public class RPC extends Connecteur{

	RPC() {
		super("RPC");
		this.rfrom.add(new RPC_RoleFrom());
		this.rto.add(new RPC_RoleTo());
	}

	@Override
	public void recevoir(Object o, RoleFrom rf) {
		
		System.out.println("Message "+ (String)o +" reçut sur le port "+ rf.getName());
		/*
		Traitement avec la glue quand on le reçoit
		*/
		envoyer(o,rto.get(0));
	}

	@Override
	public void envoyer(Object o, RoleTo rt) {
		List<Object> res = new ArrayList<Object>();
		res.add(rt.getName());
		res.add(o);
		System.out.println(this.nom+" sending "+ (String)o +" to " +rt.getName());
		
		setChanged();
		notifyObservers((Object)res);
		
	}

}
