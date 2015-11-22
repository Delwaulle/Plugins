package plugins.load;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * @author guilbertf
 *
 * Create a timer which handle every second the actions of the listener
 *
 */
public class ExtendedTimer implements ActionListener {
	
	protected ActionListener listener;
	protected Timer timer;
	
	/**
	 * @param listener
	 */
	public ExtendedTimer(ActionListener listener){
		this.listener=listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.listener.actionPerformed(e);
	}
	
	/**
	 * start the timer
	 * if the timer is already started, we reinitialize it
	 */
	public void start(){
		if(timer!=null){
			stop();
		}
		timer = new Timer(1000,this);
		timer.start();
	}

	/**
	 * stop and reinitialize the timer
	 */
	private void stop() {
		timer.stop();
		timer=null;
	}

}