package testing;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays; 

public class ArrOperationTest {

	@Test
	public void testLengthOfMirror() {
		
		int input[] = { 1, 2, 3, 8, 9, 3, 2, 1};
		assertEquals(3, ArrOperation.lengthOfMirror(input));
		
		int input2[] = { 7, 1, 4, 9, 7, 4, 1 };
		assertEquals(2, ArrOperation.lengthOfMirror(input2));
		
		int input3[] = {1, 4, 5, 3, 5, 4, 1 };
		assertEquals(7, ArrOperation.lengthOfMirror(input3));
		
		int input4[] = {1, 2, 1, 4 };
		assertEquals(3, ArrOperation.lengthOfMirror(input4));
		

	}
	@Test
	public void testNumberOfClumps() {
		int input[] = { 1, 2, 2, 3, 4, 4};
		assertEquals(2, ArrOperation.numberOfClumps(input));
		
		int input2[] = { 1, 1, 2, 1, 1};
		assertEquals(2, ArrOperation.numberOfClumps(input2));
		
		int input3[] = { 1, 1, 1, 1, 1};
		assertEquals(1, ArrOperation.numberOfClumps(input3));

	}

	@Test
	public void testFixXY() {
		int X = 4;
		int Y = 5;
		int input[] = { 5, 4, 9, 4, 9, 5};
		int output[] = {9, 4, 5, 4, 5, 9};
		assertArrayEquals(output, ArrOperation.fixXY(X, Y, input));
		
		int input1[] = { 1, 4, 1, 5};
		int output1[] = {1, 4, 5, 1};
		assertArrayEquals(output1, ArrOperation.fixXY(X, Y, input1));
		
		int input2[] = {1, 4, 1, 5, 5, 4, 1};
		int output2[] = {1, 4, 5, 1, 1, 4, 5};
		assertArrayEquals(output2, ArrOperation.fixXY(X, Y, input2));
		
	}
	@Test
	public void testIndexOfSplitArray(){
		
		int input[] = { 1, 1, 1, 2, 1 };
		assertEquals(3,ArrOperation.indexOfSplitArray(input));
		
		int input1[] = { 2, 1, 1, 2, 1};
		assertEquals(-1,ArrOperation.indexOfSplitArray(input1));
		
		int input2[] = {10,10};
		assertEquals(1,ArrOperation.indexOfSplitArray(input2));
	}

}
