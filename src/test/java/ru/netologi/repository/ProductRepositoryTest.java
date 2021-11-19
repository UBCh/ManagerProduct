package ru.netologi.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.netologi.domain.Book;
import ru.netologi.domain.Product;
import ru.netologi.domain.Smartphone;

class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    public Book coreJava = new Book(1, "book1", 100, "noName1");
    public Smartphone coreJavaS = new Smartphone(2, "telephone1", 100, "singapore");


    @BeforeEach
    public void shouldSetUp() {
        repository.save(coreJava);
        repository.save(coreJavaS);}


    @Test
    public void shoulRemoveById() {
        boolean expected = true;
        boolean actual= repository.findById(1);
        assertEquals(expected, actual); }

    @Test
    public void shouldfindByIdOne() {
        boolean expected = true;
        boolean actual= repository.findById(0);
        assertThrows(NotFoundException.class,() -> repository.removeById(3)); }



}

