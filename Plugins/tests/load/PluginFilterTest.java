package load;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import plugins.MockPlugin;
import plugins.Plugin;

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
	
	@Test
	public void getPluginsTest(){
		String path = "tests"+File.separator+"dropins"+File.separator+"plugins"+File.separator;
		PluginFinder finder = new PluginFinder(path);
		List<Plugin> list = filter.getPluginsFiles(finder.getAllFiles());
		List<Plugin> list2 = new ArrayList<Plugin>();
		list2.add(new MockPlugin());
		assertEquals(list2.get(0).getClass(), list.get(0).getClass()); //getClass = MockPlugin
	}
	
}
