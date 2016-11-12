package m2.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import m2.composant.ComposantSimple;
import m2.composantG.ComposantG;
import m2.connecteur.Connecteur;

public abstract class Configuration extends ComposantG implements Observer{
	protected List<ComposantSimple> compos = new ArrayList<ComposantSimple>();
	protected List<Configuration> conf = new ArrayList<Configuration>();
	protected List<Connecteur> connects = new ArrayList<Connecteur>();
	protected List<Binding> bindings = new ArrayList<Binding>();
	protected List<Attachement> attachements = new ArrayList<Attachement>();
	
	protected List<m2.configuration.PortFourni> pfournis = new ArrayList<m2.configuration.PortFourni>();
	protected List<m2.configuration.PortRequis> prequis = new ArrayList<m2.configuration.PortRequis>();
	
	public List<m2.configuration.PortFourni> getPfournis() {
		return pfournis;
	}

	public void addPfournis(m2.configuration.PortFourni pfournis) {
		this.pfournis.add(pfournis);
		
	}

	public List<m2.configuration.PortRequis> getPrequis() {
		return prequis;
	}

	public void addPrequis(m2.configuration.PortRequis prequis) {
		this.prequis.add(prequis);
	}

	protected Configuration(String name){
		this.nom = name;
	}

	public List<ComposantSimple> getCompos() {
		return compos;
	}

	public List<Configuration> getConf() {
		return conf;
	}

	public void setConf(List<Configuration> conf) {
		this.conf = conf;
	}

	public void addCompos(ComposantSimple compo) {
		this.compos.add(compo);
		compo.addObserver(this);
	}

	public List<Connecteur> getConnects() {
		return connects;
	}

	public void addConnects(Connecteur connect) {
		connect.addObserver(this);
		this.connects.add(connect);
		
	}

	public List<Binding> getBindings() {
		return bindings;
	}

	public void addBindings(Binding binding) {
		this.bindings.add(binding);
	}

	public List<Attachement> getAttachements() {
		return attachements;
	}

	public void addAttachements(Attachement attachement) {
		this.attachements.add(attachement);
	}

	abstract public void update(Observable o, Object arg);

	public m2.configuration.PortRequis getPortRequis(String n){
		for (m2.configuration.PortRequis each:prequis){
			if (each.getName()==n){
				return each;
			}
		
		}
		System.out.println("Element introuvable");
		return null;
		
	}
	public m2.configuration.PortFourni getPortFourni(String n){
		for (m2.configuration.PortFourni each:pfournis){
			if (each.getName()==n){
				return each;
			}
		
		}
		System.out.println("Element introuvable");
		return null;
		
	}
	
	
	
	
	
}
