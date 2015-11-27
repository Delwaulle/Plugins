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
 *         select the valid .class
 * 
 */
public class PluginFilter implements FilenameFilter {

	private static final String PARSER = "\\.class$";

	@Override
	public boolean accept(File dir, String name) {
		if (name.endsWith(".class")) {
			return acceptClass(name);
		}
		return false;
	}

	/**
	 * specific function to verify the try catch
	 * 
	 * @param name
	 * @return true if there is no error with the Class.forName
	 */
	public boolean acceptClass(String name){
		try {
			Class.forName(name.replaceFirst(PARSER, ""));
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
	
	
	/**
	 * specific function to verify the try catch
	 * 
	 * @param currentFile
	 * @return the .class of the plugin
	 */
	public Class<?> getPluginsClass(File currentFile) {
		try {
			return Class.forName("plugins."
					+ currentFile.getName().replaceFirst(PARSER, ""));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		return null;
	}

	/**
	 * specific function to verify the try catch
	 * 
	 * @param theClass
	 * @return the constructor of the class
	 */
	public Constructor<?> getPluginConstructor(Class<?> theClass) {
		try {
			return theClass.getConstructor();
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * specific function to verify the try catch
	 * in the purpose of add a plugin to our list of plugins
	 * 
	 * @param pluginsList
	 * @param emptyConstructor
	 */
	public void addPluginToList(List<Plugin> pluginsList,Constructor<?> emptyConstructor){
		try {
			pluginsList.add((Plugin) emptyConstructor.newInstance());
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * verify and add the .class of their plugins
	 * 
	 * @param list
	 * @return le list of plugins
	 */
	public List<Plugin> getPluginsFiles(List<File> list) {
		List<Plugin> pluginsList = new ArrayList<Plugin>();
		for (File currentFile : list) {
			Class<?> theClass = getPluginsClass(currentFile);
			if (theClass.isAssignableFrom(Plugin.class)) {
				Constructor<?> emptyConstructor = getPluginConstructor(theClass);
				addPluginToList(pluginsList, emptyConstructor);
			}
		}

		return pluginsList;
	}

}