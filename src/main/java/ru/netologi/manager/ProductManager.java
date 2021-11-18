package ru.netologi.manager;

import ru.netologi.domain.Book;
import ru.netologi.domain.Product;
import ru.netologi.repository.ProductRepository;
import ru.netologi.domain.Smartphone;

public class ProductManager {
    public ProductRepository repository = new ProductRepository();
     public Product product= new Product();

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
           for (Product product: repository.findAll()) {
            if (repository.matches(product, text)) {
              tmp[tmp.length - 1] = product;
            result = tmp;
            }
                    }

        return result;
    }

    }




