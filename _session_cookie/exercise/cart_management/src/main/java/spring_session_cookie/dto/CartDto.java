package spring_session_cookie.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    public Map<ProductDto,Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }
    public void addProduct(ProductDto productDto){
        //neu ton tai 1 product cung key voi product map thi value + 1
        if (productMap.containsKey(productDto)){
            int currentValue = productMap.get(productDto);
            productMap.put(productDto,currentValue+1);
            //neu chua co 1 product thi value ban dau cua no se = 1
        }else {
            productMap.put(productDto,1);
        }
    }
    public void deleteProductOnCart(ProductDto productDto){
        if (productMap.containsKey(productDto)){
            productMap.remove(productDto);
        }
    }
    public void removeProduct(ProductDto productDto){
        //neu ton tai 1 product cung key voi product map thi value - 1
        if (productMap.containsKey(productDto)){
            int currentValue = productMap.get(productDto);
            productMap.put(productDto,currentValue-1);
        }
    }
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
    public void removeAllProductOnCart(){
        productMap.clear();
    }


}
