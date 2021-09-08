package spring_session_cookie.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_session_cookie.model.entity.Product;
import spring_session_cookie.model.repository.ProductRepo;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }
}
