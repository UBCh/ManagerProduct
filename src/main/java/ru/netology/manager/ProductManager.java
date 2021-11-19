package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    public ProductRepository repository = new ProductRepository();


    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductManager() {

    }


    public void save(Product product) {
        repository.save(product);
    }

    public Product[] findAll() {
        return repository.findAll();
    }

    public Product[] searcyBy(String text) {
        Product[] result = new Product[0];
        Product[] tmp = new Product[result.length + 1];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                tmp[tmp.length - 1] = product;
                // result = System.arraycopy(tmp); - с этой строкой не компилируется,
                // проблему решить не смогла , метод просит int, а не STRING
                result = tmp;
            }
        }

        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().contains(search)) {
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }

        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getManufacturer().contains(search)) {
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
        }
        return false;
    }
}




