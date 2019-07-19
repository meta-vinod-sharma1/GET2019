package searchPkg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SearchTest {
	Search searchObj;
	
	@Before
	public void intialize(){
		searchObj = new Search();
	}

	@Test
	public void testLinearSearch() {
		int input[] =  { 1 ,2 ,3 , 4};
		assertEquals(2, searchObj.linearSearch(input, 3));
		
		int input1[] =  { 1 ,2 ,3 , 4,6,10};
		assertEquals(0, searchObj.linearSearch(input1, 1));
		
		int input2[] = { 1, 2 , 3, 4 ,5 , 6, 7 , 8 , 9};
		assertEquals(0,searchObj.linearSearch(input2, 1));
	}

	@Test
	public void testBinarySearch(){
		int input1[] =  { 1 ,14 ,5 , 8, 6,10};
		assertEquals(2, searchObj.binarySearch(input1, 3));
		
	}

}
