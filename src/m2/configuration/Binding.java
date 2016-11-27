package m2.configuration;



public abstract class Binding {
	String nom;
	private m2.configuration.PortFourni portF;
	private m2.configuration.PortRequis portR;
	private m2.composant.PortFourni portFComp;
	private m2.composant.PortRequis portRComp;
	private m2.configuration.PortFourni portFConf2;
	private m2.configuration.PortRequis portRConf2;
	
	public Binding(String nom, PortFourni pF1,m2.composant.PortFourni pF2, PortRequis pR1,m2.composant.PortRequis pR2){
		portF = pF1;
		portR = pR1;
		portFComp = pF2;
		portRComp = pR2;
		this.nom = nom;
		portFConf2 = null;
		portRConf2 = null;
	}
	
	public Binding(String nom, m2.configuration.PortFourni pF1,m2.configuration.PortFourni pF2, m2.configuration.PortRequis pR1,m2.configuration.PortRequis pR2){
		portF = pF1;
		portR = pR1;
		portFConf2 = pF2;
		portRConf2 = pR2;
		this.nom = nom;
		portFComp = null;
		portRComp = null;
	}
	
	protected abstract void Envoyer();
	protected abstract void Recevoir();
	
	public m2.configuration.PortFourni getPortFConf2() {
		return portFConf2;
	}

	public void setPortFConf2(m2.configuration.PortFourni portFConf2) {
		this.portFConf2 = portFConf2;
	}

	public m2.configuration.PortRequis getPortRConf2() {
		return portRConf2;
	}

	public void setPortRConf2(m2.configuration.PortRequis portRConf2) {
		this.portRConf2 = portRConf2;
	}

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public PortFourni getPortF() {
		return portF;
	}
	public void setPortF(PortFourni portF) {
		this.portF = portF;
	}
	public PortRequis getPortR() {
		return portR;
	}
	public void setPortR(PortRequis portR) {
		this.portR = portR;
	}
	public m2.composant.PortFourni getPortFComp() {
		return portFComp;
	}
	public void setPortFComp(m2.composant.PortFourni portFComp) {
		this.portFComp = portFComp;
	}
	public m2.composant.PortRequis getPortRComp() {
		return portRComp;
	}
	public void setPortRComp(m2.composant.PortRequis portRComp) {
		this.portRComp = portRComp;
	}
}
