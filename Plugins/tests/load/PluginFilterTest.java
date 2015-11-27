package load;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class PluginFilterTest {

	@Test
	public void pluginAcceptedTest(){
		PluginFilter filter = new PluginFilter();
		assertTrue(filter.accept(new File("plugins"), "MockPlugin.class"));
	}
	
	@Test
	public void pluginNotAcceptedTest(){
		PluginFilter filter = new PluginFilter();
		assertFalse(filter.accept(new File("plugins"), "Yoda"));
	}
	
	
}
