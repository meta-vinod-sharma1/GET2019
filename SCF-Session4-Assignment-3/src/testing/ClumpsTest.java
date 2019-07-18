package testing;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ClumpsTest {

	private int[] inputArray;
	private int expectedResult;
	private ArrOperation arrOperations;

	@Before
	public void initialize() {
		arrOperations = new ArrOperation();
	}

	public ClumpsTest(int expectedResult, int[] inputArray) {
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 2, new int[] { 1, 2, 2, 3, 4, 4 } },
				{ 2, new int[] { 1, 1, 2, 1, 1 } },
				{ 1, new int[] { 1, 1, 1, 1 } },
				{ 0, new int[] { 1, 2, 3, 4 } },
				{ 1, new int[] { 1, 2, 3, 5 } },  // negative case
				{1, new int[] {}}}); // empty array case
	}

	@Test
	public void testNumberOfClumps() {
		assertEquals(expectedResult, ArrOperation.numberOfClumps(inputArray));
	}



}
