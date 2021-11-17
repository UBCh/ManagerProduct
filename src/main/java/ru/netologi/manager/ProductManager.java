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

   public Product[] searchBy(String search ) {
        int j=0;
        Product[] tmp = new Product[j];
        for (int i =0; i < findAll().length; i++ ){
            if (search= product.name()) {tmp[j] = product;}
            if (search = product.autor ()){ tmp[j]=product;}
            if (search = product.manufacturer()){tmp[j]=product; }
            j++;
        } return tmp;

    }

    }




