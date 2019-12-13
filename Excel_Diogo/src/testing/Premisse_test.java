package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pack.ComparisonOperator;
import pack.Metric;
import pack.Premisse;

class Premisse_test {

	Premisse ge = new Premisse(Metric.ATFD, ComparisonOperator.GE, 15);
	Premisse bt = new Premisse(Metric.LAA, ComparisonOperator.BETWEEN, 10, 17);
	Premisse nbt = new Premisse(Metric.CYCLO, ComparisonOperator.NOT_BETWEEN, 11, 14); 

	void test() {

		assertEquals("ATFD >= 15 ", ge.toString());
		assertEquals("LAA IS BETWEEN 10 AND 17 ", bt.toString());
		assertEquals("CYCLO IS NOT BETWEEN 12 AND 14 ", nbt.toString());

	}
	@Test
	void test_isTrue() {
		assertTrue(ge.isTrue(16));
		assertTrue(bt.isTrue(12));
		assertFalse(nbt.isTrue(13));
	}


}
