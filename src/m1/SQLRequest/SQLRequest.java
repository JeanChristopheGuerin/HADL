package m1.SQLRequest;

import m2.connecteur.Connecteur;
import m2.connecteur.Glue;
import m2.connecteur.RoleFrom;
import m2.connecteur.RoleTo;
//TODO gerer la glue
public class SQLRequest extends Connecteur {

	public SQLRequest() {
		super("SQLRequest");
		this.rfrom.add(new Called());
		this.rto.add(new Caller());
		//this.glue = new SQLRequestGlue();
	}
	

	@Override
	public void recevoir(Object o, RoleFrom rf) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void envoyer(Object o, RoleTo rt) {
		// TODO Auto-generated method stub
		
	}

}
