package plugins;

import java.util.ArrayList;
import java.util.List;

import view.PluginObserver;

public class MockObserver implements PluginObserver{

	private int cpt;
	private List<Plugin> plugs;
	
	public MockObserver() {
		// TODO Auto-generated constructor stub
		this.setCpt(0);
		this.setPlugs(new ArrayList<Plugin>());
	}
	
	@Override
	public void changePlugin(List<Plugin> pluginsList) {
		// TODO Auto-generated method stub
		setCpt(getCpt() + 1);
		this.setPlugs(pluginsList);
	}

	public int getCpt() {
		return cpt;
	}

	public void setCpt(int cpt) {
		this.cpt = cpt;
	}

	public List<Plugin> getPlugs() {
		return plugs;
	}

	public void setPlugs(List<Plugin> plugs) {
		this.plugs = plugs;
	}

}
