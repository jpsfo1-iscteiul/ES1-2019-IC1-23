package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pack.ComparisonOperator;
import pack.Metric;
import pack.Premisse;

// TODO: Auto-generated Javadoc
/**
 * The Class Premisse_test.
 */
class Premisse_test {

	/** The ge. */
	Premisse ge = new Premisse(Metric.ATFD, ComparisonOperator.GE, 15);
	
	/** The bt. */
	Premisse bt = new Premisse(Metric.LAA, ComparisonOperator.BETWEEN, 10, 17);
	
	/** The nbt. */
	Premisse nbt = new Premisse(Metric.CYCLO, ComparisonOperator.NOT_BETWEEN, 11, 14); 

	/**
	 * Test.
	 */
	@Test
	void test() {

		assertEquals("ATFD >= 15.0 ", ge.toString());
		assertEquals("LAA IS BETWEEN 10.0 AND 17.0 ", bt.toString());
		assertEquals("CYCLO IS NOT BETWEEN 11.0 AND 14.0 ", nbt.toString());

	}
	
	/**
	 * Test is true.
	 */
	@Test
	void test_isTrue() {
		assertTrue(ge.isTrue(16));
		assertTrue(bt.isTrue(12));
		assertFalse(nbt.isTrue(13));
	}


}
