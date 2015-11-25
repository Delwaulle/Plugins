package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

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

	@Override
	public void update(List<Plugin> list) {
		this.pluginsList=list;
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}


}
