import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    @Test
    public void testEqCh() {
        CharacterComparator offBy5 = new OffByN(5);
        CharacterComparator offBy2 = new OffByN(2);
        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('f', 'a'));
        assertFalse(offBy5.equalChars('A', 'f'));
        assertTrue(offBy5.equalChars('B', 'G'));

        assertTrue(offBy2.equalChars('C', 'E'));
    }

}
