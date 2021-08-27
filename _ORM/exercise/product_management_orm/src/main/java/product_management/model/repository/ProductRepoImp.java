package product_management.model.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import product_management.model.beans.Product;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
@Controller
public class ProductRepoImp implements ProductRepo {
    @Override
    public List<Product> viewAll() {
        //code bằng Hibernate chuẩn
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession(); //mở 1 phiên làm việc mới
            //truy vấn bằng HQL là một cú pháp sql riêng của hybernate
            productList = session.createQuery("from Product").getResultList();
        }finally {
            if (session!=null){
                session.close();
            }
        }
        return productList;
// code bằng JPA
//        TypedQuery<Product> query= ConnectionUtil.entityManager.createQuery
//                ("SELECT s from Product as s ",Product.class);
//        return query.getResultList();
    }

    @Override
    public void delete(Product deleteProduct) {
//        int index = deleteProduct.getId()-1;
//        productList.remove(index);
        Transaction transaction = null;
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession(); //mở 1 phiên làm việc mới
            //truy vấn bằng HQL là một cú pháp sql riêng của hybernate
            transaction = session.beginTransaction();
            session.delete(deleteProduct);
            transaction.commit();

        }catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
        }
        finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public void update(Product editProduct) {

        Transaction transaction = null;
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession(); //mở 1 phiên làm việc mới
            //truy vấn bằng HQL là một cú pháp sql riêng của hybernate
            transaction = session.beginTransaction();
            Product product = viewById(editProduct.getId());
            product.setName(editProduct.getName());
            product.setPrice(editProduct.getPrice());
            product.setDescription(editProduct.getDescription());
            product.setProducer(editProduct.getProducer());
            session.update(product);
            transaction.commit();

        }catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
        }
        finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public Product viewById(int id) {
        TypedQuery<Product> query= ConnectionUtil.entityManager.createQuery
                ("SELECT s from Product as s where  s.id=:id",Product.class);
        query.setParameter("id",id);
        return query.getSingleResult();

    }

    @Override
    public void save(Product product) {

        Transaction transaction = null;
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession(); //mở 1 phiên làm việc mới
            //truy vấn bằng HQL là một cú pháp sql riêng của hybernate
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();

        }catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
        }
        finally {
            if (session!=null){
                session.close();
            }
        }
        // code bằng JPA
//        ConnectionUtil.entityManager.persist(product);

    }

    @Override
    public Product viewByName(String name) {

        TypedQuery<Product> query= ConnectionUtil.entityManager.createQuery
                ("SELECT s from Product as s where  s.name=:name",Product.class);
        query.setParameter("name",name);
        return query.getSingleResult();

    }
}
