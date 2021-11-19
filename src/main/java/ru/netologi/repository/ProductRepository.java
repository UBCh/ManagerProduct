package ru.netologi.repository;

import ru.netologi.domain.Book;
import ru.netologi.domain.Product;
import ru.netologi.domain.Smartphone;

public class ProductRepository {

    public Product[] items = new Product[0];


    public Book coreJava = new Book();
    public Smartphone coreJavaS = new Smartphone();

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        final Product[] items = this.items;
        return this.items;
    }

    public boolean findById(int id) {
         for (Product item : items) {
         if (item.getId() == id) {break; return true;}
              return false;
                          }
    }

    public void removeById(int id) {
        if (findById() = false)
        { throw new NotFoundException("Element with id: " + id + " not found");}
         int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
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



