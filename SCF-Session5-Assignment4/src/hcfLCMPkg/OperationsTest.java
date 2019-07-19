package hcfLCMPkg;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperationsTest {
	
	Operations operationsObj = new Operations();

	@Test
	public void testHcf() {
		assertEquals(2,operationsObj.highestCommonFactor(2, 4));
		assertEquals(1,operationsObj.highestCommonFactor(15, 7));
	}
	
	@Test
	public void testLcm() {
		assertEquals(4,operationsObj.leastCommonMultiple(2, 4));
		assertEquals(105,operationsObj.leastCommonMultiple(15, 7));
	}

}
