package m0;
import m1.*;
import m1.vueglobale.SystemeClientServeur;
import m1.vueglobale.Client;
public class Main {

	public static void main(String[] args) {
		SystemeClientServeur SCM = new SystemeClientServeur();
		Client C= (Client) SCM.getCompos().get(0);
		C.envoi("test", C.getPortFourni("Send_Request"));

	}

}
