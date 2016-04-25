package view;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.MockPlugin;

public class TextAreaTest {

	
	@Test
	public void updateViewTest(){
		MockPlugin mock = new MockPlugin();
		TextArea txtArea = new TextArea();
		txtArea.updateView(mock);
		
		assertEquals(mock.transform("SOME TEXT"), txtArea.getText());
	}
}
