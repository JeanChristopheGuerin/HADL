package m1.connectionManager;

import java.util.Arrays;

import m2.composant.ComposantSimple;
import m2.composant.PortFourni;

public class ConnectionManager extends ComposantSimple {

	public ConnectionManager() {
		super("ConnectionManager");
		this.pfournis.addAll(Arrays.asList(new DBQueryRequest(),
				new ExternalSocketSecurityRequest(),
				new SecurityCheckRequest())
				);
		this.prequis.addAll(Arrays.asList(new DBQueryResponse(),
				new ExternalSocketSecurityResponse(),
				new SecurityCheckResponse())
				);
		
	}

	@Override
	protected void envoi(Object msg, PortFourni pf) {
		// TODO Auto-generated method stub
		
	}

}
