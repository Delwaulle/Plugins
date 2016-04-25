package view;

import java.util.List;
import plugins.Plugin;

/**
 * our own observer to dodge the cast from the observer from the java api
 * @author guilbertf
 *
 */
public interface PluginObserver{

	/**
	 * Method called by the method notifyObservers from the plugin finder
	 * @param obs
	 * @param list
	 */
	public void changePlugin(List<Plugin> pluginsList);
}
