package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import plugins.Plugin;

public class Menu extends JMenuBar implements PluginObserver,ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Plugin> pluginsList;
	
	//Menus
	private JMenu fileMenu;
	private JMenu toolsMenu;
	private JMenu helpMenu;
	
	//MenusItems
	
	public Menu(){
		pluginsList=new ArrayList<Plugin>();
		this.fileMenu=new JMenu("File");
		this.toolsMenu=new JMenu("Tools");
		this.helpMenu=new JMenu("Help");
		
		//add menus to the menu bar
		this.add(fileMenu);
		this.add(toolsMenu);
		this.add(helpMenu);
	}
	
	public void updateJMenuItems(){
		JMenuItem item;
		for(Plugin plugin : this.pluginsList){
			item=new JMenuItem(plugin.getLabel());
			item.addActionListener(this);
			this.add(item);
		}
		this.repaint();
	}

	@Override
	public void changePlugin(List<Plugin> list) {
		this.pluginsList=list;
		this.updateJMenuItems();
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
	}
}