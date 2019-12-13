package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pack.Classifier;
import pack.Conclusion;

class Conclusion_test {

	@Test
	void test() {
		Conclusion conclusion = new Conclusion(Classifier.IS_LONG_METHOD, false);
		assertEquals("IS_LONG_METHOD IS FALSE", conclusion.toString());
	}

}
