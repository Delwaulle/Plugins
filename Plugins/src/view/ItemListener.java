package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import plugins.Plugin;

public class ItemListener implements ActionListener{
	
	private Plugin plugin;
	private PluginView view;
	
	public ItemListener(Plugin plugin,PluginView view){
		this.plugin=plugin;
		this.view=view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("plugin ");
		view.updateView(this.plugin);
	}

}
