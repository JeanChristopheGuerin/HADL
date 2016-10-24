package configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;





import composantG.ComposantG;
import composant.ComposantSimple;
import connecteur.Connecteur;

public abstract class Configuration extends ComposantG implements Observer{
	protected List<ComposantSimple> compos = new ArrayList<ComposantSimple>();
	protected List<Connecteur> connects = new ArrayList<Connecteur>();
	protected List<Binding> bindings = new ArrayList<Binding>();
	protected List<Attachement> attachements = new ArrayList<Attachement>();
	
	protected List<configuration.PortFourni> pfournis = new ArrayList<configuration.PortFourni>();
	protected List<configuration.PortRequis> prequis = new ArrayList<configuration.PortRequis>();
	
	public List<configuration.PortFourni> getPfournis() {
		return pfournis;
	}

	public void addPfournis(configuration.PortFourni pfournis) {
		this.pfournis.add(pfournis);
		
	}

	public List<configuration.PortRequis> getPrequis() {
		return prequis;
	}

	public void addPrequis(configuration.PortRequis prequis) {
		this.prequis.add(prequis);
	}

	protected Configuration(String name){
		this.nom = name;
	}

	public List<ComposantSimple> getCompos() {
		return compos;
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

	
	
	
	
	
}
