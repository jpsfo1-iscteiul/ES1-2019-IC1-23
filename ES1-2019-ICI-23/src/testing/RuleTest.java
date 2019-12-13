package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pack.Classifier;
import pack.ComparisonOperator;
import pack.Conclusion;
import pack.Metric;
import pack.Premisse;
import pack.Rule;

// TODO: Auto-generated Javadoc
/**
 * The Class RuleTest.
 */
class RuleTest {

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
	Rule r=new Rule("Rule locM",new Premisse(Metric.LOC,ComparisonOperator.GT, 3), new Conclusion(Classifier.IS_LONG_METHOD, true));

	/** The r 1. */
	Rule r1=new Rule("Rule cycloM",new Premisse(Metric.CYCLO,ComparisonOperator.GT, 3), new Conclusion(Classifier.IS_LONG_METHOD, true));

	/** The r 2. */
	Rule r2=new Rule("Rule locm",new Premisse(Metric.LOC,ComparisonOperator.LT, 3), new Conclusion(Classifier.FEATURE_ENVY_DEFECT, true));

	/** The r 3. */
	Rule r3=new Rule("Rule cyclom",new Premisse(Metric.CYCLO,ComparisonOperator.LT, 3), new Conclusion(Classifier.FEATURE_ENVY_DEFECT, true));

	/** The r 4. */
	Rule r4=new Rule("Rule cyclom",new Premisse(Metric.CYCLO,ComparisonOperator.LT, 3),new Premisse(Metric.ATFD, ComparisonOperator.GT, 10),"and", new Conclusion(Classifier.FEATURE_ENVY_DEFECT, true));

	/** The r 5. */
	Rule r5=new Rule("Rule cyclom",new Premisse(Metric.CYCLO,ComparisonOperator.LT, 3), new Conclusion(Classifier.FEATURE_ENVY_DEFECT, true));
		
	/*
			assertEquals(r.getPremisse1().getOperator(), ComparisonOperator.GT);
			assertEquals(r1.getPremisse1().getOperator(), ComparisonOperator.GT);
			assertEquals(r2.getPremisse1().getOperator(), ComparisonOperator.LT);
			assertEquals(r3.getPremisse1().getOperator(), ComparisonOperator.LT);
			assertEquals(true, r.getConclusion().getResult());
			assertEquals(true, r1.getConclusion().getResult());
			assertEquals(true, r2.getConclusion().getResult());
			assertEquals(true, r3.getConclusion().getResult());
			assertTrue((r4.getAndOr().equalsIgnoreCase("and"))); */


	/**
	 * Test get result double double.
	 */
	@Test
	final void testGetResultDoubleDouble() {
		//assertEquals(true, );
	}

	/**
	 * Test to string.
	 */
	@Test
	final void testToString() {
		assertEquals("Rule locM", r.toString());
	}

	/**
	 * Test get name.
	 */
	@Test
	final void testGetName() {
		assertEquals("Rule locM", r.getName());
	}

	/**
	 * Test get premisse 1.
	 */
	@Test
	final void testGetPremisse1() {
		Premisse p=new Premisse(Metric.CYCLO,ComparisonOperator.LT, 3);
		assertTrue((p.getOperator().toString().equalsIgnoreCase(r3.getPremisse1().getOperator().toString())));
		
	}


}
