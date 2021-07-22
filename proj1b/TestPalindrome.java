import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class. */

    @Test
    public void testIsPalindromeObo() {
        assertFalse(palindrome.isPalindrome("cat", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("o", cc));

        assertFalse(palindrome.isPalindrome("Abb", cc));
        assertTrue(palindrome.isPalindrome("abb", cc));

        assertTrue(palindrome.isPalindrome("cab", cc));
        assertTrue(palindrome.isPalindrome("cabb", cc));

        assertTrue(palindrome.isPalindrome("soolnpt", cc));
    }

    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("o"));

        assertFalse(palindrome.isPalindrome("Aba"));
        assertTrue(palindrome.isPalindrome("aba"));

        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("raceecar"));

        assertTrue(palindrome.isPalindrome("racewghgwecar"));
        assertFalse(palindrome.isPalindrome("racewghqgwecar"));
        assertTrue(palindrome.isPalindrome("sooloos"));
    }

}
