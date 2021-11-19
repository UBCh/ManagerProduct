package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager();
    public Book coreJava = new Book(1, "book1", 100, "noName1");
    public Book coreJava1 = new Book(2, "book2", 200, "noName1");
    public Book coreJava2 = new Book(3, "book3", 300, "noName2");
    public Smartphone coreJavaS = new Smartphone(4, "telephone1", 100, "singapore");
    public Smartphone coreJavaS2 = new Smartphone(5, "telephone2", 200, "china");
    public Smartphone coreJavaS3 = new Smartphone(6, "telephone3", 300, "singapore");

    @BeforeEach
    public void shouldSetUp() {
        manager.save(coreJava);
        manager.save(coreJava1);
        manager.save(coreJava2);
        manager.save(coreJavaS);
        manager.save(coreJavaS2);
        manager.save(coreJavaS3);

    }

    @Test
    public void shouldFindAll() {
        Product[] expected = {coreJava, coreJava1, coreJava2, coreJavaS, coreJavaS2, coreJavaS3};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacture() {
        Product[] expected = {coreJavaS2};
        Product[] actual = manager.searcyBy("china");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufactureSeveral() {
        Product[] expected = {coreJavaS, coreJavaS3};
        Product[] actual = manager.searcyBy("singapore");
        assertArrayEquals(expected, actual);


        @Test
        public void shouldSearchByAutor () {
            Product[] expected = {coreJava2};
            Product[] actual = manager.searcyBy("noName2");
            assertArrayEquals(expected, actual);
        }
        @Test
        public void shouldSearchByAutorSeveral () {
            Product[] expected = {coreJava, coreJava1};
            Product[] actual = manager.searcyBy("noName1");
            assertArrayEquals(expected, actual);
        }
        @Test
        public void shouldSearchByName () {
            Product[] expected = {coreJava};
            Product[] actual = manager.searcyBy("book1");
            assertArrayEquals(expected, actual);
        }
        @Test
        public void shouldSearchByFourName () {
            Product[] expected = {coreJavaS};
            Product[] actual = manager.searcyBy("telephone1");
            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldSearchByFiveNameNegativ () {
            Product[] expected = {};
            Product[] actual = manager.searcyBy("telefone");
            assertArrayEquals(expected, actual);
        }
    }