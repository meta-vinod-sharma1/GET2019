package testing;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LengthOfMirrorTest {

	private int[] inputArray;
	private int expectedResult;
	private ArrOperation arrOperations;

	@Before
	public void initialize() {
		arrOperations = new ArrOperation();
	}

	public LengthOfMirrorTest(int expectedResult, int[] inputArray) {
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 3, new int[] { 1, 2, 3, 8, 9, 3, 2, 1 } },
				{ 4, new int[] { 1, 1, 2, 2, 2, 2 } },
				{ 2, new int[] { 1, 1, 2, 2, 3, 3 } },
				{ 5, new int[] { 1, 1, 1, 1, 1 } },
				{ 6, new int[] { 1, 2, 3, 8, 9, 3, 2, 1 } }, // negative case
				{ 5, new int[] { 1, 2, 3, 2, 1 } },
				{ 4, new int[] { 7, 7, 7, 7, 6, 7 } }, 
				{ 1, new int[] {} } }); //empty array
	}

	@Test
	public void testLengthOfMirror() {
		assertEquals(expectedResult, ArrOperation.lengthOfMirror(inputArray));
	}

}
