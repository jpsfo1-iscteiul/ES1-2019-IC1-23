package testing;

import static org.junit.Assert.*;

import javax.swing.JTable;

import org.junit.Before;
import org.junit.Test;

import pack.*;

public class Defects_testing {
	
	UI ui = new UI();
	Defects d1;
	Defects d2;
	
	
	@Before
	private void setup() {
		ui.initialize();
		d1 = new Defects(new UI().getTable(), Classifier.IPLASMA);
		d2= new Defects(new JTable(), Classifier.PMD);
	}
	
	
	@Test
	public void testDefects() {
		assertTrue(d1.getName().equals(d1.getADCI()));
		assertTrue(d1.getName().equals(d1.getADII()));
		assertTrue(d1.getName().equals(d1.getDCI()));
		assertTrue(d1.getName().equals(d1.getDII()));
		
		assertTrue(d2.getName().equals(d2.getADCI()));
		assertTrue(d2.getName().equals(d2.getADII()));
		assertTrue(d2.getName().equals(d2.getDCI()));
		assertTrue(d2.getName().equals(d2.getDII()));
		
	
	}

	@Test
	public void testGetDCI() {
		assertEquals(140 , (int) d1.getDCI());
		assertEquals(140,(int) d2.getDCI());
		
		
		
	}

	@Test
	public void testGetDII() {
		assertEquals(0,(int) d1.getDII());
		assertEquals(18,(int) d2.getDII());
		
		
	}

	@Test
	public void testGetADCI() {
		assertEquals(280,(int) d1.getADCI());
		assertEquals(262,(int) d2.getADCI());
		
	}

	@Test
	public void testGetADII() {
		assertEquals(0, (int)d1.getADII());
		assertEquals(0, (int) d2.getADII());
	}

	

}
