package product_management.model.repository;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;


public class ConnectionUtil {
    //khai báo 1 số thuộc tính
     public static EntityManager entityManager;
     public static SessionFactory sessionFactory;
     static {
         try {
             sessionFactory= new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
             entityManager = sessionFactory.createEntityManager();
         }catch (HibernateException e){
             e.printStackTrace();
         }
     }
}
