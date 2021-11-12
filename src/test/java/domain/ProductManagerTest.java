package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;


class ProductManagerTest {
    ProductRepository test = new ProductRepository();
    ProductManager one = new ProductManager();
    public Book coreJava = new Book(1, "book1", 100, "noName1");
    public Smartphone coreJavaS = new Smartphone(2, "telephone1", 100, "singapore");

    @Test
    public void searchBy() {
        test.save(coreJava);
        test.save(coreJavaS);
        Product[] expected = {coreJava, coreJavaS};
        Product[] actual = test.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void matches_one() {
        test.save(coreJavaS);
        boolean expected = true;
        boolean actual = test.matches(coreJavaS, "singapore");
        assertEquals(expected, actual);
    }

    @Test
    public void matches_two() {
        test.save(coreJava);
        boolean expected = true;
        boolean actual = test.matches(coreJava, "noName1");
        assertEquals(expected, actual);
    }

    @Test
    public void matches_three() {
        test.save(coreJava);
        boolean expected = false;
        boolean actual = test.matches(coreJava, "noName2");
        assertEquals(expected, actual);
    }

    @Test
    public void matches_four() {
        test.save(coreJavaS);
        boolean expected = false;
        boolean actual = test.matches(coreJavaS, "singapore2");
        assertEquals(expected, actual);
    }
}