package m1.vueglobale;

import m2.configuration.Binding;

import m2.configuration.PortFourni;
import m2.configuration.PortRequis;

public class ServeurGServeurBind extends Binding{

	public ServeurGServeurBind( PortFourni pF1,
			PortFourni pF2, PortRequis pR1,
			PortRequis pR2) {
		super("ServeurGServeurBind", pF1, pF2, pR1, pR2);
	}

	@Override
	protected void Envoyer() {
		
		
	}

	@Override
	protected void Recevoir() {
		
		
	}

}
