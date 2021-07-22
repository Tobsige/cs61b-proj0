/**
 * A class for off-by-N comparators.
 *
 * @author Xueyi Wang
 */
public class OffByN implements CharacterComparator {
    private int n;

    public OffByN(int num) {
        n = num;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        int a = (int) 'a', aa = (int) 'A', z = (int) 'z', zz = (int) 'Z',
                xi = (int) x, yi = (int) y;
        //if ((xi >= a && xi <= zz || xi >= aa && xi <= zz) &&
        //        (yi >= a && yi <= aa || yi >= aa && yi <= zz))
        if ((xi >= a && xi <= zz) && (yi >= aa && yi <= zz)
                || (xi >= aa && xi <= zz) && (yi >= a && yi <= z)) {
            return false;
        }
        if (diff == n) {
            return true;
        }
        return false;
    }
}
