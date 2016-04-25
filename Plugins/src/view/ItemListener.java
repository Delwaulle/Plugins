package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import plugins.Plugin;

/**
 * My listener for the menu items
 * @author delwaulle
 *
 */
public class ItemListener implements ActionListener{
	
	private Plugin plugin;
	private PluginView view;
	
	/**
	 * @param plugin
	 * @param view
	 */
	public ItemListener(Plugin plugin,PluginView view){
		this.plugin=plugin;
		this.view=view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		view.updateView(this.plugin);
	}

}
