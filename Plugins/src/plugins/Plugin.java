package plugins;

/**
 * @author Loic
 *
 */
public interface Plugin {
	
	/**
	 * @param s
	 * @return
	 */
	public String transform(String s);
	
	
	/**
	 * @return the name of the plugin
	 */
	public String getLabel();

}
