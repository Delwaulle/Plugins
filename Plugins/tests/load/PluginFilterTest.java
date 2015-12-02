package load;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import plugins.MockPlugin;

public class PluginFilterTest {
	PluginFilter filter;

	@Before
	public void initNewFilter(){
		this.filter = new PluginFilter();
	}
	
	@Test
	public void pluginAcceptedTest(){
		assertTrue(filter.accept(new File("plugins"), "MockPlugin.class"));
	}
	
	@Test
	public void pluginNotAcceptedTest(){
		assertFalse(filter.accept(new File("plugins"), "Yoda"));
	}
	
	@Test
	public void badAcceptClassTest(){
		assertFalse(filter.acceptClass("ThisIsNotAPlugin"));
	}
	
	@Test
	public void returnNullClassForPlugin(){
		assertNull(filter.getPluginsClass("ThisIsNotAPlugin.class"));
	}
	
	@Test
	public void getPluginConstructor() throws NoSuchMethodException, SecurityException{
		Class<?> theClass = filter.getPluginsClass("MockPlugin.class");
		assertEquals(MockPlugin.class.getConstructor(null), filter.getPluginConstructor(theClass));
		//MockPlugin doesn't have parameters in his constructor
	}
	
	@Test
	public void badGetPluginConstructor(){
		Class<?> theClass = filter.getPluginsClass("ThisIsNotAPlugin.class");
		assertNull(filter.getPluginConstructor(theClass));
	}
	
	
}
