package m1.connectionManager;

import java.util.Arrays;

import m2.composant.ComposantSimple;
import m2.composant.PortFourni;
import m2.composant.PortRequis;

public class ConnectionManager extends ComposantSimple {

	public ConnectionManager() {
		super("ConnectionManager");
		this.pfournis.addAll(Arrays.asList(new DBQueryRequest(),
				new ExternalSocketSecurityRequest(),
				new SecurityCheckRequest(),
				new DBQueryRequest())
				);
		this.prequis.addAll(Arrays.asList(new DBQueryResponse(),
				new ExternalSocketSecurityResponse(),
				new SecurityCheckResponse(),
				new DBQueryResponse())
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
