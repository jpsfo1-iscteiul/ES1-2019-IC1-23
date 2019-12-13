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
import pack.UI;

// TODO: Auto-generated Javadoc
/**
 * The Class UITest.
 */
class UITest {

	/** The ui. */
	UI ui;
	
	/**
	 * Test.
	 */
	@Test
	public void test() {
		UI ui=new UI();
		ui.initialize();
		assertTrue(ui.getTable().isEnabled());
		ui.getFeNewRule().doClick();
		ui.getLmNewRule().doClick();
		Premisse p1 = new Premisse(Metric.CYCLO, ComparisonOperator.EQUAL, 3);
		Premisse p2 = new Premisse(Metric.LOC, ComparisonOperator.GE, 5);
		Rule rule = new Rule("Rule1", p1, p2, "AND", new Conclusion(Classifier.IPLASMA, true));
		ui.fillColumn(rule);
	}
	
//	@Test
//	public void test_buttons() {
//		ui.fillColumn(new Rule("Rule locM",new Premisse(Metric.LOC,ComparisonOperator.GT, 3), new Conclusion(Classifier.IS_LONG_METHOD, true)));
//	}
	
	

}
