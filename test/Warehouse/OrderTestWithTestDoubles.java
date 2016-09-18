package Warehouse;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderTestWithTestDoubles {
    private static String WINGS_OF_FIRE_BOOK = "Wings of fire";
    private static String IGNITED_MINDS_BOOK = "Ignited Minds";
    private WarehouseStub warehouseStub;

    @Before
    public void setUp() {
    warehouseStub = new WarehouseStub();
    }

    @Test
    public void testOrderIsFilledIfEnoughInWarehouse() {
        Order order = new Order(WINGS_OF_FIRE_BOOK, 4);

        order.fill(warehouseStub);

        Assert.assertTrue(order.isFilled());
    }

    @Test
    public void testOrderDoesNotRemoveIfNotEnoughInWarehouse() {
        Order order = new Order(IGNITED_MINDS_BOOK, 2);

        order.fill(warehouseStub);

        Assert.assertFalse(order.isFilled());
    }
}
