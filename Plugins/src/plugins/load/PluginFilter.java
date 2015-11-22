package plugins.load;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author guilbertf
 *
 *
 *	select the valid .class
 *
 */
public class PluginFilter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		if(name.endsWith(".class")){
			try {
				Class.forName(name.replaceFirst("\\.class$", ""));
				return true;
			} catch (ClassNotFoundException e) {
				return false;
			}
		}
		return false;
	}

}