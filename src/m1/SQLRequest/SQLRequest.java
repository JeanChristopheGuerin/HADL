package m1.SQLRequest;

import java.util.ArrayList;
import java.util.List;

import m2.connecteur.Connecteur;
import m2.connecteur.Glue;
import m2.connecteur.RoleFrom;
import m2.connecteur.RoleTo;
//TODO gerer la glue
public class SQLRequest extends Connecteur {

	public SQLRequest() {
		super("SQLRequest");
		this.rfrom.add(new CalledSQLRequest());
		this.rfrom.add(new Called2SQLRequest());
		this.rto.add(new CallerSQLRequest());
		this.rto.add(new Caller2SQLRequest());
		//this.glue = new SQLRequestGlue();
	}
	

	@Override
	public void recevoir(Object o, RoleFrom rf) {
		if(rf.getName() == "Called2SQLRequest"){
			System.out.println("Message "+ (String)o +" recu sur "+this.getNom()+" sur le port "+ rf.getName());
			envoyer(o,rto.get(0));
		}else {
			System.out.println("Message "+ (String)o +" recu sur "+this.getNom()+" sur le port "+ rf.getName());
			envoyer(o,rto.get(1));
		}
		
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
