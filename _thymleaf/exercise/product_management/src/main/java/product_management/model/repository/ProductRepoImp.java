package product_management.model.repository;

import org.springframework.stereotype.Controller;
import product_management.model.beans.Product;

import java.util.ArrayList;
import java.util.List;
@Controller
public class ProductRepoImp implements ProductRepo {
    static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"Iphone",5000000,"Import","China"));
        productList.add(new Product(2,"Xiaomi",60000000,"Import","Japan"));
        productList.add(new Product(3,"Bphone",40000000,"Inland","Vietnam"));
        productList.add(new Product(4,"Vsmart",10000000,"Inland","Vietnam"));
    }

    @Override
    public List<Product> viewAll() {
        return productList;
    }

    @Override
    public void delete(Product deleteProduct) {
        int index = deleteProduct.getId()-1;
        productList.remove(index);
    }

    @Override
    public void update(Product editProduct) {
        for (Product product: productList){
            if (product.getId()==editProduct.getId()){
                product.setName(editProduct.getName());
                product.setPrice(editProduct.getPrice());
                product.setDescription(editProduct.getDescription());
                product.setProducer(editProduct.getProducer());
            }
        }
    }

    @Override
    public Product viewById(int id) {
        for (Product product: productList){
            if (product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product viewByName(String name) {
        for (Product product: productList){
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }
}
