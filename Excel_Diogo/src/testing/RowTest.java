package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pack.Row;

// TODO: Auto-generated Javadoc
/**
 * The Class RowTest.
 */
class RowTest {

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/** The r. */
	Row r=new Row(1, "packageName", "className", "method", 2, 3, 4, 5.0, true,true,true,true );
	
	/**
	 * Test row.
	 */
	@Test
	final void testRow() {
		assertEquals(r.getMethodID(),1 );
	}

	/**
	 * Test get I plasma.
	 */
	@Test
	final void testGetIPlasma() {
		assertEquals(r.getIPlasma(), true);
	}

	/**
	 * Test get is feature envy.
	 */
	@Test
	final void testGetIsFeatureEnvy() {
		assertEquals(r.getIsFeatureEnvy(), true);
	}

	/**
	 * Test get is long method.
	 */
	@Test
	final void testGetIsLongMethod() {
		assertEquals(r.getIsLongMethod(), true);
	}

	/**
	 * Test get method ID.
	 */
	@Test
	final void testGetMethodID() {
		assertEquals(r.getMethodID(), 1);
	}

	/**
	 * Test get package name.
	 */
	@Test
	final void testGetPackageName() {
		assertTrue(r.getPackageName().equalsIgnoreCase("packageName"));
	}

	/**
	 * Test get method.
	 */
	@Test
	final void testGetMethod() {

		assertTrue(r.getMethod().equalsIgnoreCase("method"));
	}

	/**
	 * Test get loc.
	 */
	@Test
	final void testGetLoc() {
		assertEquals(r.getLoc(), 2 );
		
	}

	/**
	 * Test get cyclo.
	 */
	@Test
	final void testGetCyclo() {

		assertEquals(r.getCyclo(), 3);
	}

	/**
	 * Test get atdf.
	 */
	@Test
	final void testGetAtdf() {

		assertEquals(r.getAtdf(), 4);
	}

	/**
	 * Test get laa.
	 */
	@Test
	final void testGetLaa() {

		assertEquals(r.getLaa(), 5);
	}

	/**
	 * Test get pmd.
	 */
	@Test
	final void testGetPmd() {

		assertEquals(true, r.getPmd());
	}

	/**
	 * Test to string.
	 */
	@Test
	final void testToString() {

		assertEquals(true, r.getIsFeatureEnvy());
	}

}
