package view;

import plugins.Plugin;

/**
 * @author delwaulle
 *
 */
public interface PluginView {

	/**
	 * update the view with the current plugin
	 * @param plugin
	 */
	public void updateView(Plugin plugin);
}
