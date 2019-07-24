package testing;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FixXYTest {

	private int[] inputArray;
	private int X;
	private int Y;
	private int[] expectedResult;
	private ArrOperation arrOperations;

	@Before
	public void initialize() {
		arrOperations = new ArrOperation();
	}

	public FixXYTest(int[] expectedResult, int[] inputArray,int X, int Y) {
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
		this.X = X;
		this.Y = Y;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{new int[] {9,4,5,4,5,9}, new int[] {5,4,9,4,9,5},4,5},
				{new int[] {1,4,5,1}, new int[] {1,4,1,5},4,5},
				{new int[] {1,4,5,1,1,4,5}, new int[] {1,4,1,5,5,4,1},4,5},
				{new int[] {1,5,4,1,1,4,5}, new int[] {1,4,1,5,5,4,1},4,5},    //negative case
				{new int[] {1,4,5,4,4,1,1}, new int[] {1,4,4,5,5,1,1},4,5},    //throw two adjacent X error
				{new int[] {1,4,5,4,1,4,5}, new int[] {1,4,1,5,4,5,4},4,5}});    //throw unequal X and Y error
	}

	@Test
	public void testLengthOfMirror() {
		assertArrayEquals(expectedResult, ArrOperation.fixXY(X, Y, inputArray));
	}

}

