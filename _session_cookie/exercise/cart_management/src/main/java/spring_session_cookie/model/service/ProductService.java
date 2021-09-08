package spring_session_cookie.model.service;


import spring_session_cookie.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(int id);
    void save(Product product);
}
