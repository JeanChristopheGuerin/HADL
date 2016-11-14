package m2.configuration;


import m2.configuration.PortFourni;
import m2.configuration.PortRequis;
import m2.connecteur.RoleFrom;
import m2.connecteur.RoleTo;
public abstract class AttachementConf {
	String nom;
	private PortFourni portF;
	private PortRequis portR;
	private RoleFrom roleFrom;
	private RoleTo roleTo;
	protected AttachementConf(String nom, PortFourni pF,PortRequis pR, RoleFrom rF, RoleTo rT){
		portF = pF;
		portR = pR;
		roleFrom = rF;
		roleTo = rT;
		this.nom = nom;
	}
	public abstract void envoyer(Object msg);
	public abstract Object recevoir();
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
	public RoleFrom getRoleFrom() {
		return roleFrom;
	}
	public void setRoleFrom(RoleFrom roleFrom) {
		this.roleFrom = roleFrom;
	}
	public RoleTo getRoleTo() {
		return roleTo;
	}
	public void setRoleTo(RoleTo roleTo) {
		this.roleTo = roleTo;
	}
}

