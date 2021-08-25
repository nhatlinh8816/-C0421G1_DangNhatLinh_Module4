package product_management.model.service;

import product_management.model.beans.Product;

import java.util.List;

public interface ProductService {
    List<Product> viewAll();
    void delete(Product product);
    void update(Product editProduct);
    Product viewById(int id);
    void save(Product product);
    Product viewByName(String name);
}
