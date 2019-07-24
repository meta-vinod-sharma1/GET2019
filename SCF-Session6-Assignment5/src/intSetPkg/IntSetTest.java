package intSetPkg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntSetTest {
	IntSet intSetObj = null;
	
	@Before
	public void initialize(){
		int inputArray[] = {1,2,3,4,5,11,12,13,14,15};
		intSetObj = new IntSet(inputArray);
	}

	@Test
	public void testIsMember() {
		assertEquals(true,intSetObj.isMember(3));
		assertEquals(true,intSetObj.isMember(13));
		assertEquals(true,intSetObj.isMember(1));
		assertEquals(true,intSetObj.isMember(15));
		assertEquals(false,intSetObj.isMember(16));
		assertEquals(false,intSetObj.isMember(0));
		assertEquals(false,intSetObj.isMember(20));
	}

	@Test
	public void testSize() {
		int inputArray[] = {1,2,3,4,5};
		IntSet intSetObj1 = new IntSet(inputArray);
		assertEquals(5,intSetObj1.size());
		
		int inputArray1[] = {1,2,3,4,5,6,7,8,9,10};
		IntSet intSetObj2 = new IntSet(inputArray1);
		assertEquals(10,intSetObj2.size());
		
		int inputArray2[] = {1};
		IntSet intSetObj3 = new IntSet(inputArray2);
		assertEquals(1,intSetObj3.size());
		
		int inputArray3[] = {};
		IntSet intSetObj4 = new IntSet(inputArray3);
		assertEquals(0,intSetObj4.size());
	}
			

	@Test
	public void testIsSubSet() {
		int inputArray[] = {1,2,3};
		IntSet subSetObj = new IntSet(inputArray);
		assertEquals(true,intSetObj.isSubSet(subSetObj));
		
		int inputArray1[] = {1,2,3,4,5,6,7,8,9};
		IntSet subSetObj1 = new IntSet(inputArray1);
		assertEquals(false,intSetObj.isSubSet(subSetObj1));
		
		int inputArray2[] = {1,2,3,3,3,3,3,};
		IntSet subSetObj2 = new IntSet(inputArray2);
		assertEquals(true,intSetObj.isSubSet(subSetObj2));
		
		int inputArray3[] = {1,2,3,3,3,3,3,8,9,10,11,12,13,14,15,16,17,18,19};
		IntSet subSetObj3 = new IntSet(inputArray3);
		assertEquals(false,intSetObj.isSubSet(subSetObj3));
		
	}

	@Test
	public void testUnion() {
		int s1Array[] = {1,2,3,4,5,5,6,6,6,6,7};
		IntSet s1 = new IntSet(s1Array);
		int s2Array[] = {100,102,0,109,110};
		IntSet s2 = new IntSet(s2Array);
		int outputArray[] = {0,1,2,3,4,5,6,7,100,102,109,110};
		assertArrayEquals(outputArray,intSetObj.union(s1, s2));
		
		
		int s12Array[] = {1,2,3};
		IntSet s12 = new IntSet(s12Array);
		int s22Array[] = {2,5,9,10,15};
		IntSet s22 = new IntSet(s22Array);
		int outputArray1[] = {1,2,3,5,9,10,15};
		assertArrayEquals(outputArray1,intSetObj.union(s12, s22));
	}

}

