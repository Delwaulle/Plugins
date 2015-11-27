package load;

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
public class PluginFinder extends PluginObservable implements ActionListener{

	protected ExtendedTimer finderListener;
	protected String directory;
	protected PluginFilter filter;
	protected List<File> pluginsFilesList;
	
	
	/**
	 * @param directory
	 */
	public PluginFinder(String directory){
		this.directory=directory;
		this.pluginsFilesList=new ArrayList<File>();
		this.finderListener= new ExtendedTimer(this);
		finderListener.start();
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
		List<File> list=this.getAllFiles();
		if(!(this.pluginsFilesList.equals(list))){
			this.pluginsFilesList=this.getAllFiles();
			this.notifyObservers(filter.getPluginsFiles(list));	
		}		
	}

}