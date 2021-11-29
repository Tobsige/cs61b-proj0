package lab9;

import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author Xueyi Wang
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;  /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        Node n = new Node(null, null);
        root = n;
        size = 0;
    }

    /** Returns the value mapped to by KEY in the subtree rooted in P.
     *  or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        if (key.compareTo(p.key) == 0) {
            return p.value;
        }
        Node pl = p.left, pr = p.right;
        if (key.compareTo(p.key) < 0 && pl != null) {
            return getHelper(key, pl);
        } else if (key.compareTo(p.key) > 0 && pr != null) {
            return getHelper(key, p.right);
        } else {
            return null;
        }
    }

    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        if (size == 0) {
            return null;
        }
        return getHelper(key, root);
    }

    /** Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
      * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        if (key.compareTo(p.key) == 0) {
            p.value = value;
            return p;
        }
        Node pl = p.left, pr = p.right;
        if (key.compareTo(p.key) < 0 && pl != null) {
            return putHelper(key, value, pl);
        } else if (key.compareTo(p.key) > 0 && pr != null) {
            return putHelper(key, value, pr);
        } else if (key.compareTo(p.key) < 0 && pl == null) {
            Node pNew = new Node(key, value);
            p.left = pNew;
            size += 1;
            return pl;
        } else {
            Node pNew = new Node(key, value);
            size += 1;
            p.right = pNew;
            return pr;
        }
    }

    /** Inserts the key KEY
     *  If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        if (size == 0) {
            root.key = key;
            root.value = value;
            size += 1;
            return;
        }
        putHelper(key, value, root);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /** Removes KEY from the tree if present
     *  returns VALUE removed,
     *  null on failed removal.
     */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /** Removes the key-value entry for the specified key only if it is
     *  currently mapped to the specified value.  Returns the VALUE removed,
     *  null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    public static void main(String args[]) {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertEquals(null, b.get("starChild"));
        assertEquals(0, b.size());
        b.put("starChild", 5);
        assertTrue(((Integer) b.get("starChild")).equals(5));
        b.put("KISS", 5);
        assertTrue(((Integer) b.get("KISS")).equals(5));
        assertNotEquals(null, b.get("starChild"));
        assertEquals(2, b.size());

    }
}
