package m1.vueglobale;

import m2.configuration.Binding;
import m2.configuration.PortFourni;
import m2.configuration.PortRequis;

public class SystemeClientBind extends Binding{

	public SystemeClientBind(PortFourni pF1, m2.composant.PortFourni pF2,
			PortRequis pR1, m2.composant.PortRequis pR2) {
		super("SystemeClientBind", pF1, pF2, pR1, pR2);
		
	}



	@Override
	protected void Envoyer() {
		
		
	}

	@Override
	protected void Recevoir() {
		
		
	}

}
