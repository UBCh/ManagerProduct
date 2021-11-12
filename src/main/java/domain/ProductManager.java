package domain;

public class ProductManager {
    public ProductRepository repository = new ProductRepository();



    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductManager() {

    }

    public Book coreJava = new Book(1,"book1", 100,"noName1");
    public Smartphone coreJavaS = new Smartphone(2,"telephone1", 100,"singapore");
    public void save(Product product) {
        repository.save(product);
    }

    public Product[] findAll() {
        return repository.findAll();
    }

    public Product[] searchBy(String text) {
        return repository.findAll();
    }

    public boolean matches(Product product) {
        boolean found = repository.matches(coreJava,"noName1" );
        return found;
    }
}



