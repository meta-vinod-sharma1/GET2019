package zooPkg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ZooOperationTest {
	ZooOperation obj = new ZooOperation();
	@Before
	public void Initialize(){
		obj.start();
	}

	@Test
	public void testAddAnimalOperation() {
		
		// For Category Mammal and type Lion
		assertEquals(true,obj.addAnimalOperation("lion1" , 4, 65.1, "Mammal", "Lion"));
		assertEquals(true,obj.addAnimalOperation("lion1" , 4, 65.1, "Mammal", "Lion")); // Cage Full here 
		assertEquals(false,obj.addAnimalOperation("lion1" , 4, 65.1, "Mammal", "Lion")); // After Cage Full should come with false
	//	assertEquals(true,obj.addAnimalOperation("lion1" , 4, 65.1, "Mammal", "Lion"));  // Negative Case
		
		// For type tiger
		assertEquals(true,obj.addAnimalOperation("Tiger1" , 3, 50, "Mammal", "Tiger"));// Cage Full here
		assertEquals(false,obj.addAnimalOperation("Tiger1" , 3, 50, "Mammal", "Tiger")); // After Case Full
	//	assertEquals(true,obj.addAnimalOperation("Tiger1" , 3, 50, "Mammal", "Tiger"));// Negative Case
		
		// For type Parrot
		assertEquals(true,obj.addAnimalOperation("parrot1" , 1, 10, "Bird", "Parrot"));// Cage Full here
		assertEquals(false,obj.addAnimalOperation("parroot1" , 1, 7, "Bird", "Parrot")); // After Case Full
	//	assertEquals(true,obj.addAnimalOperation("Tiger1" , 3, 50, "Mammal", "Tiger"));// Negative Case
		
		//For type Snake
		assertEquals(true,obj.addAnimalOperation("snake1" , 1, 10, "Reptile", "Snake"));// Cage Full here
		assertEquals(false,obj.addAnimalOperation("snake2" , 1, 7, "Reptile", "Snake")); // After Case Full
	//	assertEquals(true,obj.addAnimalOperation("Tiger1" , 3, 50, "Mammal", "Tiger"));// Negative Case
		
		
	}
/*
	@Test
	public void testAddCageOperation() {
		
	}

	@Test
	public void testTotalAnimal() {
		fail("Not yet implemented"); // TODO
	}
*/
}
