package m1.serveur;

import m2.composant.PortFourni;
import m2.composant.PortRequis;
import m2.configuration.Attachement;
import m2.connecteur.RoleFrom;
import m2.connecteur.RoleTo;

public class ConnectionManagerTOSQLRequest extends Attachement{

	protected ConnectionManagerTOSQLRequest(PortFourni pF,
			PortRequis pR, RoleFrom rF, RoleTo rT) {
		super("ConnectionManagerTOSQLRequest", pF, pR, rF, rT);
		// TODO Auto-generated constructor stub
	}

}
