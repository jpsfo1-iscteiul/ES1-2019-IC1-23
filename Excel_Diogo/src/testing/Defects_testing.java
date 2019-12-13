package testing;

import static org.junit.Assert.*;

import javax.swing.JTable;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import pack.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Defects_testing.
 */
public class Defects_testing {
	
	/** The ui. */
	UI ui;
	
	/** The d 1. */
	Defects d1;
	
	/** The d 2. */
	Defects d2;
	
	
	
	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		ui = new UI();
		ui.initialize();
		d1 = new Defects(ui.getTable(), Classifier.IPLASMA);
		d2= new Defects(ui.getTable(), Classifier.PMD);
	}
	
	
	/**
	 * Test names.
	 */
	@Test
	public void testNames() {
		assertTrue(d1.getName().equals("IPLASMA"));
		assertTrue(d2.getName().equals("PMD"));
		
	
	}

	/**
	 * Test get DCI.
	 */
	@Test
	public void testGetDCI() {
		assertEquals(140 , (int) d1.getDCI());
		assertEquals(140,(int) d2.getDCI());
		
		
		
	}

	/**
	 * Test get DII.
	 */
	@Test
	public void testGetDII() {
		assertEquals(0,(int) d1.getDII());
		assertEquals(18,(int) d2.getDII());
		
		
	}

	/**
	 * Test get ADCI.
	 */
	@Test
	public void testGetADCI() {
		assertEquals(280,(int) d1.getADCI());
		assertEquals(262,(int) d2.getADCI());
		
	}

	/**
	 * Test get ADII.
	 */
	@Test
	public void testGetADII() {
		assertEquals(0, (int)d1.getADII());
		assertEquals(0, (int) d2.getADII());
	}

	

}
