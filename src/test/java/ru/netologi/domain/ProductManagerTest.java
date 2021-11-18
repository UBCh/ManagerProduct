package ru.netologi.domain;

import org.junit.jupiter.api.Test;
import ru.netologi.manager.ProductManager;
import ru.netologi.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager();
    public Book coreJava = new Book(1, "book1", 100, "noName1");
    public Smartphone coreJavaS = new Smartphone(2, "telephone1", 100, "singapore");


    @BeforeEach
    public void shouldSetUp() {
        manager.save(coreJava);
        manager.save(coreJavaS);

    }

    @Test
    public void shouldFindAll() {
        Product[] expected = {coreJava, coreJavaS};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy_one() {
        Product[] expected = {coreJavaS};
        Product[] actual = manager.searcyBy("singapore");
        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSearchBy_two() {
        Product[] expected = {coreJava};
        Product[] actual = manager.searcyBy("noName1");
        assertArrayEquals(expected, actual);
     }
    @Test
    public void shouldSearchBy_three() {
        Product[] expected = {coreJava};
        Product[] actual = manager.searcyBy("book1");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchBy_four() {
        Product[] expected = {coreJavaS};
        Product[] actual = manager.searcyBy("telephone1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy_five() {
        Product[] expected = {};
        Product[] actual = manager.searcyBy("telefone");
        assertArrayEquals(expected, actual);
    }
}