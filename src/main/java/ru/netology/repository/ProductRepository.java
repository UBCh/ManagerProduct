package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

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
            if (item.getId() == id) {
                break;
                return true;
            }
            return false;
        }
    }

    public void removeById(int id) {
        if (findById() = false) // здесь тоже не смогла найти причину
        {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
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


}



