package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Menu extends JMenuBar implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Menus
	private JMenu fileMenu;
	private JMenu toolsMenu;
	private JMenu helpMenu;
	
	//MenusItems
	
	public Menu(){
		this.fileMenu=new JMenu("File");
		this.toolsMenu=new JMenu("Tools");
		this.helpMenu=new JMenu("Help");
		
		//add menus to the menu bar
		this.add(fileMenu);
		this.add(toolsMenu);
		this.add(helpMenu);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
