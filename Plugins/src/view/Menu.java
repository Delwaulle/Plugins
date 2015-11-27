package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import plugins.Plugin;

public class Menu extends JMenuBar implements PluginObserver{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Plugin> pluginsList;
	
	//Menus
	private JMenu fileMenu;
	private JMenu toolsMenu;
	private JMenu helpMenu;
	
	//view
	private PluginView view;
	
	
	public Menu(PluginView view){
		this.view=view;
		pluginsList=new ArrayList<Plugin>();
		this.fileMenu=new JMenu("File");
		this.toolsMenu=new JMenu("Tools");
		this.helpMenu=new JMenu("Help");
		
		//add menus to the menu bar
		this.add(fileMenu);
		this.add(toolsMenu);
		this.add(helpMenu);
		
		//set actions and add plugins to tools menu
		updateJMenuItems();
	}
	
	public void updateJMenuItems(){
		toolsMenu.removeAll();
		JMenuItem item;
		if(this.pluginsList.isEmpty()){
			item=new JMenuItem("No available plugin(s)");
			item.setEnabled(false);
			this.toolsMenu.add(item);
		}
		else{
			for(Plugin plugin : this.pluginsList){
				item=new JMenuItem(plugin.getLabel());
				item.addActionListener(new ItemListener(plugin,view));
				this.toolsMenu.add(item);
			}
		}
		this.repaint();
		this.revalidate();
	}

	@Override
	public void changePlugin(List<Plugin> list) {
		this.pluginsList=list;
		this.updateJMenuItems();
	}
}