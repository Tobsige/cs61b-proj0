/**
 * A class for off-by-N comparators.
 *
 * @author Xueyi Wang
 */
public class OffByN implements CharacterComparator {
    private int n;
    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        if (diff == n) {
            return true;
        }
        return false;
    }
}
