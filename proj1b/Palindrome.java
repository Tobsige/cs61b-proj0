/**
 * A class for palindrome operations.
 *
 * @author Xueyi Wang
 */
public class Palindrome {
    /** Put characters in the given word in Deque.*/
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new LinkedListDeque<>();
        if (word == null) {
            return wordDeque;
        }
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    /** Justify if the given word is a palindrome*/
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        int len = wordDeque.size();
        if (len == 1 || len == 0) {
            return true;
        }
        return isPldr(wordDeque);
    }

    private boolean isPldr(Deque d) {
        /*
        int count = d.size() / 2;
        for(int i = 0; i < count; i++) {
            if (d.get(i) != d.get(d.size() - 1 - i)) {
                return false;
            }
        }*/
        int len = d.size();
        if (len == 1 || len == 0) {
            return true;
        } else if (d.removeFirst() == d.removeLast()) {
            return isPldr(d);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wd = wordToDeque(word);
        int len = wd.size();
        if (len == 1 || len == 0) {
            return true;
        }
        return isPldrObo(wd, cc);
    }

    private boolean isPldrObo(Deque d, CharacterComparator cc) {
        int len = d.size();
        if (len == 1 || len == 0) {
            return true;
        } else if (cc.equalChars((char) d.removeFirst(), (char) d.removeLast())) {
            return isPldrObo(d, cc);
        } else {
            return false;
        }
    }

}
