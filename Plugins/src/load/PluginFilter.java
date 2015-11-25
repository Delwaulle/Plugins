package load;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import plugins.Plugin;

/**
 * @author guilbertf
 *
 *
 *	select the valid .class
 *
 */
public class PluginFilter implements FilenameFilter{
	
	private static final String PARSER = "\\.class$";

	@Override
	public boolean accept(File dir, String name) {
		if(name.endsWith(".class")){
			try {
				Class.forName(name.replaceFirst(PARSER, ""));
				return true;
			} catch (ClassNotFoundException e) {
				return false;
			}
		}
		return false;
	}
	
	public List<Plugin> getPluginsFiles(List<File> list){
		List<Plugin> pluginsList = new ArrayList<Plugin>();
		for(File currentFile : list){
			try {
				Class<?> theClass=Class.forName("plugins."+currentFile.getName().replaceFirst(PARSER, ""));
				if(theClass.isAssignableFrom(Plugin.class)){
					try {
						Constructor<?> emptyConstructor = theClass.getConstructor();

						try {
							pluginsList.add((Plugin) emptyConstructor.newInstance());
						} catch (InstantiationException
								| IllegalAccessException
								| IllegalArgumentException
								| InvocationTargetException e) {
							e.printStackTrace();
						}
					} catch (NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return pluginsList;
	}

}