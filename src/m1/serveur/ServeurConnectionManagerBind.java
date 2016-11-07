package m1.serveur;
import m2.configuration.Binding;
import m2.configuration.PortFourni;
import m2.configuration.PortRequis;


public class ServeurConnectionManagerBind extends Binding{

	public ServeurConnectionManagerBind(PortFourni pF1,
			m2.composant.PortFourni pF2, PortRequis pR1,
			m2.composant.PortRequis pR2) {
		super("ServeurConnectionManagerBind", pF1, pF2, pR1, pR2);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void Envoyer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void Recevoir() {
		// TODO Auto-generated method stub
		
	}

}
