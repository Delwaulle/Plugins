package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;

import plugins.Plugin;

public class TextArea extends JTextArea implements PluginView,KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Plugin plugin;

	@Override
	public void updateView(Plugin plugin) {
		this.plugin=plugin;
		if(this.plugin!=null)
			this.setText(plugin.transform(this.getText()));
		this.repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		updateView(this.plugin);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {	
	}

}
