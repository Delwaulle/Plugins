package load;

import java.util.List;

import plugins.Plugin;
import view.PluginObserver;

public abstract class PluginObservable {

	private List<PluginObserver> observersList;
	
	public void addObserver(PluginObserver observer){
		this.observersList.add(observer);
	}
	
	public void deleteObservers(){
		this.observersList.removeAll(observersList);
	}

	public void notifyObservers(List<Plugin> list){
		for(PluginObserver observer : this.observersList)
			observer.changePlugin(list);		
	}
}
