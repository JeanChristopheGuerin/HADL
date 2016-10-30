package m2.configuration;


import m2.composant.PortFourni;
import m2.composant.PortRequis;
import m2.connecteur.RoleFrom;
import m2.connecteur.RoleTo;
public abstract class Attachement {
	String nom;
	private m2.composant.PortFourni portF;
	private m2.composant.PortRequis portR;
	private RoleFrom roleFrom;
	private RoleTo roleTo;
	protected Attachement(String nom, m2.composant.PortFourni pF,m2.composant.PortRequis pR, RoleFrom rF, RoleTo rT){
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
	public m2.composant.PortFourni getPortF() {
		return portF;
	}
	public void setPortF(m2.composant.PortFourni portF) {
		this.portF = portF;
	}
	public m2.composant.PortRequis getPortR() {
		return portR;
	}
	public void setPortR(m2.composant.PortRequis portR) {
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
