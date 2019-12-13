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

class RuleTest {

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
	
	Rule r=new Rule("Rule locM",new Premisse(Metric.LOC,ComparisonOperator.GT, 3), new Conclusion(Classifier.IS_LONG_METHOD, true));

	Rule r1=new Rule("Rule cycloM",new Premisse(Metric.CYCLO,ComparisonOperator.GT, 3), new Conclusion(Classifier.IS_LONG_METHOD, true));

	Rule r2=new Rule("Rule locm",new Premisse(Metric.LOC,ComparisonOperator.LT, 3), new Conclusion(Classifier.FEATURE_ENVY_DEFECT, true));

	Rule r3=new Rule("Rule cyclom",new Premisse(Metric.CYCLO,ComparisonOperator.LT, 3), new Conclusion(Classifier.FEATURE_ENVY_DEFECT, true));

	Rule r4=new Rule("Rule cyclom",new Premisse(Metric.CYCLO,ComparisonOperator.LT, 3),new Premisse(Metric.ATFD, ComparisonOperator.GT, 10),"and", new Conclusion(Classifier.FEATURE_ENVY_DEFECT, true));

	Rule r5=new Rule("Rule cyclom",new Premisse(Metric.CYCLO,ComparisonOperator.LT, 3), new Conclusion(Classifier.FEATURE_ENVY_DEFECT, true));
		
			
			assertEquals(r.getPremisse1().getOperator(), ComparisonOperator.GT);
			assertEquals(r1.getPremisse1().getOperator(), ComparisonOperator.GT);
			assertEquals(r2.getPremisse1().getOperator(), ComparisonOperator.LT);
			assertEquals(r3.getPremisse1().getOperator(), ComparisonOperator.LT);
			assertEquals(true, r.getConclusion().getResult());
			assertEquals(true, r1.getConclusion().getResult());
			assertEquals(true, r2.getConclusion().getResult());
			assertEquals(true, r3.getConclusion().getResult());
			assertTrue((r4.getAndOr().equalsIgnoreCase("and")));

	@Test
	final void testRuleStringPremissePremisseStringConclusion() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testRuleStringPremisseConclusion() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetResultDoubleDouble() {
		assertEquals()
	}

	@Test
	final void testGetResultDouble() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testToString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetConclusion() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetPremisse1() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetPremisse2() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetAndOr() {
		fail("Not yet implemented"); // TODO
	}

}
