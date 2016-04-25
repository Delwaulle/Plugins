package plugins;

/**
 * Plugin for the application
 * @author Loic
 *
 */
public interface Plugin {
	
	/**
	 * @param s
	 * @return the plugin transformation
	 */
	public String transform(String s);
	
	
	/**
	 * @return the name of the plugin
	 */
	public String getLabel();

}
