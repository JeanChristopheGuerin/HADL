package m1.SQLRequest;

import m2.composant.PortFourni;
import m2.composant.PortRequis;
import m2.connecteur.Glue;
import m2.connecteur.RoleFrom;
import m2.connecteur.RoleTo;

public class SQLRequestGlue extends Glue{

	SQLRequestGlue(PortFourni pF, RoleFrom rF) {
		super(pF, rF);
		// TODO Auto-generated constructor stub
	}
	SQLRequestGlue(PortRequis pR, RoleTo rT) {
		super(pR, rT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionColler() {
		// TODO ecrire l'action de glue specifique à ce connecteur
		
	}

}
