package Warehouse;

import java.util.Map;

class WarehouseStub extends Warehouse {
    private static String WINGS_OF_FIRE_BOOK = "Wings of fire";
    private static String IGNITED_MINDS_BOOK = "Ignited Minds";

    @Override
    public Integer getInventory(String product){
        if(product.equals(WINGS_OF_FIRE_BOOK)){
            return  5;
        }
        if(product.equals(IGNITED_MINDS_BOOK)){
            return  1;
        }
        return 0;
    }
}
