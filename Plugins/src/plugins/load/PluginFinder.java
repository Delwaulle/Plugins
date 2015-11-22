package plugins.load;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guilbertf
 *
 * Research into the directory (in param) all the plugins which validated by the PluginFilter
 *
 */
public class PluginFinder implements ActionListener{

	protected ExtendedTimer finderListener;
	protected String directory;
	protected PluginFilter filter;
	List<File> plugins;
	
	
	/**
	 * @param directory
	 */
	public PluginFinder(String directory){
		this.directory=directory;
		this.plugins=new ArrayList<File>();
		this.finderListener= new ExtendedTimer(this);
		filter = new PluginFilter();
	}

	/**
	 * @return a list with all the valid files
	 */
	public List<File> getAllFiles(){
		File dir = new File(this.directory);
		File[] files = dir.listFiles(filter);
		if(files == null)
			return new ArrayList<File>();	
		return new ArrayList<File>(Arrays.asList(files));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!(this.plugins.equals(this.getAllFiles()))) //soon compare to
			this.notify();			
	}
	
}