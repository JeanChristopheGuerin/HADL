package configuration;


import connecteur.RoleFrom;
import connecteur.RoleTo;
import composant.PortFourni;
import composant.PortRequis;
public abstract class Attachement {
	String nom;
	private composant.PortFourni portF;
	private composant.PortRequis portR;
	private RoleFrom roleFrom;
	private RoleTo roleTo;
	protected Attachement(String nom, composant.PortFourni pF,composant.PortRequis pR, RoleFrom rF, RoleTo rT){
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
	public composant.PortFourni getPortF() {
		return portF;
	}
	public void setPortF(composant.PortFourni portF) {
		this.portF = portF;
	}
	public composant.PortRequis getPortR() {
		return portR;
	}
	public void setPortR(composant.PortRequis portR) {
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
