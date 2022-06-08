package data_structures;

import org.junit.Test;
import org.junit.Assert;
import java.util.LinkedList;
import java.util.List;

public class BagTest {
    @Test
    public void testConstructor() {
        Bag<String> bag = new Bag<>();

        Assert.assertNotNull(bag);
    }

    @Test
    public void testIteration() {
        List<String> testData = new LinkedList<>();
        testData.add("Hello");
        testData.add("World");
        testData.add("How are you?");

        Bag<String> bag = new Bag<>(testData);

        for (String string: bag){
            Assert.assertNotNull(string);
        }


    }

    @Test
    public void testMultiSetProperties() {
        Bag<String> bag = new Bag<>();

        String a = "Hello";
        String b = "Hello";

        Assert.assertEquals(a, b);
        bag.add(a);
        bag.add(b);

        for (String string: bag){
            Assert.assertNotNull(string);
        }


    }

    @Test
    public void testAdding() {
        Bag<Integer> bag = new Bag<>();
        bag.add(10);

        for (int number: bag){
            Assert.assertEquals(10, number);
        }


    }

}