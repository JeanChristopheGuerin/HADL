package m2.configuration;



public abstract class Binding {
	String nom;
	private PortFourni portF;
	private PortRequis portR;
	private m2.composant.PortFourni portFComp;
	private m2.composant.PortRequis portRComp;
	protected Binding(String nom, PortFourni pF1,m2.composant.PortFourni pF2, PortRequis pR1,m2.composant.PortRequis pR2){
		portF = pF1;
		portR = pR1;
		portFComp = pF2;
		portRComp = pR2;
		this.nom = nom;
	}
	protected abstract void Envoyer();
	protected abstract void Recevoir();
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
