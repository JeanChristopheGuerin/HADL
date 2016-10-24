package m1_vueglobale;
import composant.ComposantSimple;
import composant.PortFourni;

public class Serveur extends ComposantSimple{

	protected Serveur() {
		super("Serveur");
		Receive_Request RR = new Receive_Request();
		Receive_Request_Response RRR = new Receive_Request_Response();
		this.pfournis.add(RRR);
		this.prequis.add(RR);
	}

	@Override
	protected void envoi(Object msg, PortFourni pf) {
		// TODO Auto-generated method stub
		
	}

}
