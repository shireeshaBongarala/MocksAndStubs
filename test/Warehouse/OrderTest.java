package Warehouse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {
    private static String WINGS_OF_FIRE_BOOK = "Wings of fire";
    private static String IGNITED_MINDS_BOOK = "Ignited Minds";
    private Warehouse warehouse = new Warehouse();

    @Before
    public void setUp() {
        warehouse.add(WINGS_OF_FIRE_BOOK, 5);
        warehouse.add(IGNITED_MINDS_BOOK, 1);
    }

    @Test
    public void testOrderIsFilledIfEnoughInWarehouse() {
        Order order = new Order(WINGS_OF_FIRE_BOOK, 4);

        order.fill(warehouse);

        Assert.assertTrue(order.isFilled());
    }

    @Test
    public void testOrderDoesNotRemoveIfNotEnoughInWarehouse() {
        Order order = new Order(IGNITED_MINDS_BOOK, 2);

        order.fill(warehouse);

        Assert.assertFalse(order.isFilled());
    }

}
