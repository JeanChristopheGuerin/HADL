package m0;
import m1.*;
import m1.vueglobale.SystemeClientServeur;
import m1.vueglobale.Client;
public class Main {

	public static void main(String[] args) {
		SystemeClientServeur SCM = new SystemeClientServeur();
		SCM.getCompos().get(0).envoi("test", SCM.getCompos().get(0).getPortFourni("Send_Request"));
		System.out.println(SCM.getCompos().get(0).getPortFourni("Send_Request").name);
	}

}
