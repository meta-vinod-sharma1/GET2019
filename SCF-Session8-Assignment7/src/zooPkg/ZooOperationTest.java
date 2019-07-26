package zooPkg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ZooOperationTest {
	ZooOperation obj = new ZooOperation();
	@Before
	public void Initialize(){
		// Zone added
		obj.addZoneOperation("Mammal", 4, true, true);
		obj.addZoneOperation("Bird", 2, true, true);
		
		// Cages Added
		obj.addCageOperation("Mammal", "Lion", 2);
		obj.addCageOperation("Mammal", "Tiger", 1);
		obj.addCageOperation("Bird", "Parrot", 1);
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
		
		
	}
	
	@Test
	public void testAddCageOperation() {
		assertEquals(true, obj.addCageOperation("Mammal", "Lion", 2));
		assertEquals(true, obj.addCageOperation("Mammal", "Tiger", 1)); //Zone full here
		assertEquals(false, obj.addCageOperation("Mammal", "Tiger", 1));
	//	assertEquals(true, obj.addCageOperation("Mammal", "Tiger", 1)); // Negative Case
	
	}
	@Test
	public void testTotalAnimal() {
		assertEquals(true,obj.addAnimalOperation("lion1" , 4, 65.1, "Mammal", "Lion"));
		assertEquals(1,obj.totalAnimal());
		
		assertEquals(true,obj.addAnimalOperation("lion1" , 4, 65.1, "Mammal", "Lion"));
		assertEquals(2,obj.totalAnimal());
		
		assertEquals(true,obj.addAnimalOperation("Tiger1" , 3, 50, "Mammal", "Tiger"));
		assertEquals(3,obj.totalAnimal());
		
		assertEquals(true,obj.addAnimalOperation("parrot1" , 1, 10, "Bird", "Parrot"));
	// 	assertEquals(3,obj.totalAnimal());   //Negative Case
		

	}
}
