package m1_vueglobale;

import configuration.Binding;
import configuration.PortFourni;
import configuration.PortRequis;

public class SystemeClientBind extends Binding{

	public SystemeClientBind(PortFourni pF1, composant.PortFourni pF2,
			PortRequis pR1, composant.PortRequis pR2) {
		super("SystemeClientBind", pF1, pF2, pR1, pR2);
		
	}



	@Override
	protected void Envoyer() {
		
		
	}

	@Override
	protected void Recevoir() {
		
		
	}

}
