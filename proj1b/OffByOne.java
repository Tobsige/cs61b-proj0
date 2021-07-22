/**
 * A class for off-by-1 comparators.
 *
 * @author Xueyi Wang
 */
public class OffByOne implements CharacterComparator {
    @Override
    /** Returns true if characters are equal by the rules of the implementing class. */
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        if (diff == 1) {
            return true;
        }
        return false;
    }
}
