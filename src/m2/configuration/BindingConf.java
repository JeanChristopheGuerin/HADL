package m2.configuration;

public abstract class BindingConf{
	String nom;
	private PortFourni portF;
	private PortRequis portR;
	private PortFourni portFComp;
	private PortRequis portRComp;
	public BindingConf(String nom, PortFourni pF1,PortFourni pF2, PortRequis pR1,PortRequis pR2){
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
	public PortFourni getPortFComp() {
		return portFComp;
	}
	public void setPortFComp(PortFourni portFComp) {
		this.portFComp = portFComp;
	}
	public PortRequis getPortRComp() {
		return portRComp;
	}
	public void setPortRComp(PortRequis portRComp) {
		this.portRComp = portRComp;
	}
}
