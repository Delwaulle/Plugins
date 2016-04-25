package load;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import plugins.Plugin;


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
	protected List<Plugin> pluginList;
	
	
	/**
	 * @param directory
	 */
	public PluginFinder(String directory){
		this.directory=directory;
		this.pluginsFilesList=new ArrayList<File>();
		this.pluginList = new ArrayList<Plugin>();
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
			this.pluginList = filter.getPluginsFiles(list);
			this.notifyObservers(pluginList);
			this.pluginsFilesList=list;
		}		
	}

	public List<Plugin> getPluginList() {
		return pluginList;
	}

	public void setPulginList(List<Plugin> pulginList) {
		this.pluginList = pulginList;
	}

}