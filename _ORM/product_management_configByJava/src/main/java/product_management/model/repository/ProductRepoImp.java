package product_management.model.repository;


import org.springframework.stereotype.Controller;
import product_management.model.beans.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;
@Controller
@Transactional
public class ProductRepoImp implements ProductRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> viewAll() {
        TypedQuery<Product> query = entityManager.createQuery
                ("SELECT s from Product as s ", Product.class);
        return query.getResultList();
    }

    @Override
    public void delete(Product deleteProduct) {
        entityManager.remove(entityManager.merge(deleteProduct));
    }

    @Override
    public void update(Product editProduct) {
        entityManager.merge(editProduct);
    }

    @Override
    public Product viewById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void save(Product product) {
            entityManager.persist(product);
    }

    @Override
    public Product viewByName(String name) {
        TypedQuery<Product> query= entityManager.createQuery
                ("SELECT s from Product as s where  s.name=:name",Product.class);
        query.setParameter("name",name);
        return query.getSingleResult();
    }
}
