package product_management.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_management.model.beans.Product;
import product_management.model.repository.ProductRepo;

import java.util.List;
@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepo productRepo;
    @Override
    public List<Product> viewAll() {
        return productRepo.viewAll();
    }

    @Override
    public void delete(Product deleteProduct) {
        productRepo.delete(deleteProduct);
    }

    @Override
    public void update(Product editProduct) {
        productRepo.update(editProduct);
    }

    @Override
    public Product viewById(int id) {
        return productRepo.viewById(id);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product viewByName(String name) {
        return productRepo.viewByName(name);
    }
}
