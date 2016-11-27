package m2.configuration;



import m2.connecteur.RoleFrom;
import m2.connecteur.RoleTo;
public abstract class Attachement {
	public String nom;
	private m2.composant.PortFourni portF;
	private m2.composant.PortRequis portR;
	private m2.configuration.PortFourni portFConf;
	private m2.configuration.PortRequis portRConf;
	private RoleFrom roleFrom;
	private RoleTo roleTo;
	protected Attachement(String nom, m2.composant.PortFourni pF,m2.composant.PortRequis pR, RoleFrom rF, RoleTo rT){
		portF = pF;
		portR = pR;
		roleFrom = rF;
		roleTo = rT;
		this.nom = nom;
		portFConf = null;
		portRConf = null;
	}
	protected Attachement(String nom, m2.configuration.PortFourni pF,m2.configuration.PortRequis pR, RoleFrom rF, RoleTo rT){
		portFConf = pF;
		portRConf = pR;
		roleFrom = rF;
		roleTo = rT;
		this.nom = nom;
		portF = null;
		portR = null;
	}
	
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
	public m2.configuration.PortFourni getPortFConf() {
		return portFConf;
	}
	public void setPortFConf(m2.configuration.PortFourni portFConf) {
		this.portFConf = portFConf;
	}
	public m2.configuration.PortRequis getPortRConf() {
		return portRConf;
	}
	public void setPortRConf(m2.configuration.PortRequis portRConf) {
		this.portRConf = portRConf;
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
