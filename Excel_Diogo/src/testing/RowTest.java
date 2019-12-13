package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pack.Row;

class RowTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	Row r=new Row(1, "packageName", "className", "method", 2, 3, 4, 5.0, true,true,true,true );
	@Test
	final void testRow() {
		assertEquals(r.getMethodID(),1 );
	}

	@Test
	final void testGetIPlasma() {
		assertEquals(r.getIPlasma(), true);
	}

	@Test
	final void testGetIsFeatureEnvy() {
		assertEquals(r.getIsFeatureEnvy(), true);
	}

	@Test
	final void testGetIsLongMethod() {
		assertEquals(r.getIsLongMethod(), true);
	}

	@Test
	final void testGetMethodID() {
		assertEquals(r.getMethodID(), 1);
	}

	@Test
	final void testGetPackageName() {
		assertTrue(r.getPackageName().equalsIgnoreCase("packageName"));
	}

	@Test
	final void testGetMethod() {

		assertTrue(r.getMethod().equalsIgnoreCase("method"));
	}

	@Test
	final void testGetLoc() {
		assertEquals(r.getLoc(), 2 );
		
	}

	@Test
	final void testGetCyclo() {

		assertEquals(r.getCyclo(), 3);
	}

	@Test
	final void testGetAtdf() {

		assertEquals(r.getAtdf(), 4);
	}

	@Test
	final void testGetLaa() {

		assertEquals(r.getLaa(), 5);
	}

	@Test
	final void testGetPmd() {

		assertEquals(true, r.getPmd());
	}

	@Test
	final void testToString() {

		assertEquals(true, r.getIsFeatureEnvy());
	}
	@Test
	final void testClassName() {

		assertTrue(r.getMethod().equalsIgnoreCase("className"));
	}

}
