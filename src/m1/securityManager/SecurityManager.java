package m1.securityManager;

import java.util.Arrays;

import m2.composant.ComposantSimple;
import m2.composant.PortFourni;
import m2.composant.PortRequis;


public class SecurityManager extends ComposantSimple {

	public SecurityManager() {
		super("SecurityManager");

		this.pfournis.addAll(Arrays.asList(new ConnectionQuery())
				);
		this.prequis.addAll(Arrays.asList(new ConnectionQueryResponse(),
				new SecurityAuthentification())
				);
		

	}

	@Override
	public void envoi(Object msg, PortFourni pf) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void recevoir(Object msg, PortRequis portR) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recevoir(String msg, PortFourni pf) {
		// TODO Auto-generated method stub
		
	}

}


