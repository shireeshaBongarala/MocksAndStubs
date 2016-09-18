package Warehouse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class OrderTestWithMockitoFramework {
    private static String WINGS_OF_FIRE_BOOK = "Wings of fire";
    private static String IGNITED_MINDS_BOOK = "Ignited Minds";

    @Mock
    private Warehouse warehouse;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testOrderIsFilledIfEnoughInWarehouse() {
        Order order = new Order(WINGS_OF_FIRE_BOOK, 4);

        when(warehouse.getInventory(WINGS_OF_FIRE_BOOK)).thenReturn(5);
        order.fill(warehouse);

        Assert.assertTrue(order.isFilled());
    }

    @Test
    public void testOrderDoesNotRemoveIfNotEnoughInWarehouse() {
        Order order = new Order(IGNITED_MINDS_BOOK, 2);

        when(warehouse.getInventory(IGNITED_MINDS_BOOK)).thenReturn(1);
        order.fill(warehouse);

        Assert.assertFalse(order.isFilled());
        verify(warehouse, times(1)).getInventory(IGNITED_MINDS_BOOK);
    }

    @Test
    public void testOrderFillingRemovesInventoryInStock() {
        Order order = new Order(WINGS_OF_FIRE_BOOK, 4);

        when(warehouse.getInventory(WINGS_OF_FIRE_BOOK)).thenReturn(5,1);
        order.fill(warehouse);

        Assert.assertTrue(order.isFilled());
        verify(warehouse, times(1)).getInventory(WINGS_OF_FIRE_BOOK);
        verify(warehouse, times(1)).removeInventory(WINGS_OF_FIRE_BOOK, 4);
    }
    
}
