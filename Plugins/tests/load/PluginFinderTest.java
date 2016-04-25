package load;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.junit.Before;
import org.junit.Test;

import plugins.MockObserver;
import plugins.Plugin;
import view.Menu;

public class PluginFinderTest {
	PluginFinder finder;
	static final String PATH ="tests"+File.separator+"dropins"+File.separator+"plugins"+File.separator;
	List<File> actualList;
	List<File> expectedList;
	MockObserver mockObs; 
	
	@Before
	public void init(){
		finder = new PluginFinder(PATH);
		actualList = finder.getAllFiles();
		expectedList = new ArrayList<File>();
		expectedList.add(new File(PATH+"MockPlugin.class"));
		mockObs = new MockObserver();
		finder.addObserver(mockObs);
	}
	
	@Test
	public void getAllFilesTest(){
		assertEquals(expectedList, actualList);
	}
	
	@Test
	public void badGetAllFilesTest(){
		finder = new PluginFinder("This Is Not A Directory");
		actualList = finder.getAllFiles();
		assertNotEquals(expectedList, actualList);
	}
	
	@Test
	public void actionPerformedTest(){
					
		assertEquals(0, mockObs.getCpt());
		assertTrue(mockObs.getPlugs().isEmpty());
		
		finder.actionPerformed(null);
		
		assertEquals(1, mockObs.getCpt());
		assertEquals(finder.getPluginList(), mockObs.getPlugs());
	}
	
	@Test
	public void notifyObsververTest(){
		
		finder.notifyObservers(finder.getPluginList());
		
		assertEquals(finder.getPluginList(), mockObs.getPlugs());
	}
}
