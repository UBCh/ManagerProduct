package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;

class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    public Book coreJava = new Book(1, "book1", 100, "noName1");
    public Book coreJava1 = new Book(2, "book2", 200, "noName1");
    public Book coreJava2 = new Book(3, "book3", 300, "noName2");
    public Smartphone coreJavaS = new Smartphone(4, "telephone1", 100, "singapore");
    public Smartphone coreJavaS2 = new Smartphone(5, "telephone2", 200, "china");
    public Smartphone coreJavaS3 = new Smartphone(6, "telephone3", 300, "singapore");

    @BeforeEach
    public void shouldSetUp() {
        repository.save(coreJava);
        repository.save(coreJava1);
        repository.save(coreJava2);
        repository.save(coreJavaS);
        repository.save(coreJavaS2);
        repository.save(coreJavaS3);


        @Test
        public void shoulRemoveById() {
            boolean expected = true;
            boolean actual = repository.findById(1);
            assertEquals(expected, actual);
        }

        @Test
        public void shouldfindByIdOne() {
            boolean expected = true;
            boolean actual = repository.findById(0);
            assertThrows(NotFoundException.class, () -> repository.removeById(3));
        }


    }

