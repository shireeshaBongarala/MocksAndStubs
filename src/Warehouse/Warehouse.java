package Warehouse;


import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<String, Integer> productQuantityList;

    Warehouse(){
      productQuantityList = new HashMap<String, Integer>();
    }

    public void add(String product, Integer quantity){
        productQuantityList.put(product, quantity);
    }

    public Integer getInventory(String product){
        return productQuantityList.get(product);
    }
}
