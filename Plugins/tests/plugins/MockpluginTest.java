package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class MockpluginTest {
	MockPlugin mock = new MockPlugin();
	
	@Test
	public void transformTest(){
		assertEquals(mock.transform("SomeText"), "");
	}
}
