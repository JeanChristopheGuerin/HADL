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
	protected List<BindingConf> bindingsConf = new ArrayList<BindingConf>();
	protected List<Attachement> attachements = new ArrayList<Attachement>();
	protected List<AttachementConf> attachementsConf = new ArrayList<AttachementConf>();
	
	protected List<m2.configuration.PortFourni> pfournis = new ArrayList<m2.configuration.PortFourni>();
	protected List<m2.configuration.PortRequis> prequis = new ArrayList<m2.configuration.PortRequis>();
	
	protected Configuration(String name){
		this.nom = name;
	}

	//////////////////////
	
	public void addPfournis(m2.configuration.PortFourni pfournis) {
		this.pfournis.add(pfournis);
		
	}

	public void addPrequis(m2.configuration.PortRequis prequis) {
		this.prequis.add(prequis);
	}

	public void addCompos(ComposantSimple compo) {
		this.compos.add(compo);
		compo.addObserver(this);
	}

	public void addConnects(Connecteur connect) {
		connect.addObserver(this);
		this.connects.add(connect);
		
	}
	public void addConf(Configuration conf){
		conf.addObserver(this);
		this.conf.add(conf);
	}
	
	
	//////////////////////
	
	public void addAllPfournis(List<m2.configuration.PortFourni> pfournis) {
		this.pfournis.addAll(pfournis);
		
	}

	public void addAllPrequis(List<m2.configuration.PortRequis> prequis) {
		this.prequis.addAll(prequis);
	}

	public void addAllCompos(List<ComposantSimple> compo) {
		this.compos.addAll(compo);
		for (ComposantSimple each : compo){
			each.addObserver(this);
		}
	}

	public void addAllConnects(List<Connecteur> connect) {
		this.connects.addAll(connect);
		for(Connecteur each : connect){
			each.addObserver(this);
		}
	}
	
	public void addAllConf(List<Configuration> conf){
		this.conf.addAll(conf);
		for (Configuration each : conf){
			each.addObserver(this);
		}
	}
	

	//////////////////////

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
	
	//////////////////////
	abstract public void update(Observable o, Object arg);

	public List<ComposantSimple> getCompos() {
		return compos;
	}

	public List<Configuration> getConf() {
		return conf;
	}

	public List<Connecteur> getConnects() {
		return connects;
	}

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
	
	public abstract void recevoir(Object msg,PortRequis pr);
	public abstract void envoyer(Object msg,PortFourni pf);
	
	
	
}
