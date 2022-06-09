package data_structures.symbol_tables;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestBinarySearchTree {

    @Test
    public void testSearching() {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();

        bst.put(10, 10);
        bst.put(5, 1);
        bst.put(100, 3);
        bst.put(0, 2);

        assertEquals(10, (int) bst.get(10));

    }

}