package session4Pkg.uniquePkg;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueCharactersTestCase {

    UniqueCharacters stringObject = new UniqueCharacters();

    /**
     * When single string contains both unique And repeated characters and returns no. of UniqueCharacters
     */
    @Test
    public void test1() {
        assertEquals(1, stringObject.countUniqueCharacters("abcdabcee"));
        assertEquals(0, stringObject.countUniqueCharacters("eeedd"));
        assertEquals(2, stringObject.countUniqueCharacters("This is the pen"));
        assertEquals(4, stringObject.countUniqueCharacters("My name is Ayushi"));
        assertEquals(1, stringObject.countUniqueCharacters("THIS this"));
    }
   
}