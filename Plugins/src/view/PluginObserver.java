package view;

import java.util.List;
import java.util.Observer;


import plugins.Plugin;

/**
 * our own observer to dodge the cast from the observer from the java api
 * @author guilbertf
 *
 */
public interface PluginObserver extends Observer{

	/**
	 * Method called by the method notifyObservers from the model
	 * @param obs
	 * @param list
	 */
	public void update( List<Plugin> list);
}
