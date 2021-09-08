package spring_session_cookie.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_session_cookie.model.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
