package view;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import load.PluginFinder;

/**
 * Display the window of the application
 * @author Loic
 *
 */
public class MyFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Initialize components of the JFrame
	 */
	public MyFrame(JMenuBar menu){
		super("Extendable Editor");
		
		//add the menu bar to the JFrame
		this.setJMenuBar(menu);
		
		//set size and options
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setVisible(true);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);	
	}
	
	/**
	 * launch the window and the application
	 * @param args
	 */
	public static void main(String [] args){
		
		PluginFinder pluginFinder = new PluginFinder("plugins");
		Menu menu = new Menu();
		
		pluginFinder.addObserver(menu);
		new MyFrame(menu);
	}

}
