package view;
import java.io.File;

import javax.swing.JFrame;

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
	
	public static final String PATH ="dropins" +File.separator+"plugins"+File.separator;
	
	/**
	 * Initialize components of the JFrame
	 */
	public MyFrame(){
		super("Extendable Editor");
		
		//textArea
		TextArea textArea=new TextArea();
		
		//pluginfinder
		PluginFinder pluginFinder = new PluginFinder(PATH);
		//menu
		Menu menu = new Menu(textArea);	
		
		//fix the observer
		pluginFinder.addObserver(menu);
		
		//add the menu bar to the JFrame
		this.setJMenuBar(menu);
		
		//add the view to the content pane
		this.getContentPane().add(textArea);
		
		//set size and options
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setVisible(true);
		
	}
	
	/**
	 * launch the window and the application
	 * @param args
	 */
	public static void main(String [] args){
		new MyFrame();
	}

}
