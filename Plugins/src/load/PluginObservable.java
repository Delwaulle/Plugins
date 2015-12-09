package load;

import java.util.ArrayList;
import java.util.List;

import plugins.Plugin;
import view.PluginObserver;

/**
 * My implementation of observable 
 * @author delwaulle
 *
 */
public abstract class PluginObservable {

	private List<PluginObserver> observersList=new ArrayList<PluginObserver>();
	
	/**
	 * Add a new observer to the list
	 * @param observer
	 */
	public void addObserver(PluginObserver observer){
		this.observersList.add(observer);
	}
	
	/**
	 * remove all the observers from the list
	 */
	public void deleteObservers(){
		this.observersList.removeAll(observersList);
	}

	/**
	 * Call the update method of the associated observer
	 * @param list
	 */
	public void notifyObservers(List<Plugin> list){
		for(PluginObserver observer : this.observersList)
			observer.changePlugin(list);		
	}
}
