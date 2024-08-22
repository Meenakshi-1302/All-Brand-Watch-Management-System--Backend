package com.mb.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mb.model.Inventory;
import com.mb.repo.InventoryRepository;

class InventoryServiceImplTest {

    @InjectMocks
    private InventoryServiceImpl inventoryserviceimpl;

    @Mock
    private InventoryRepository inventoryrepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddInventory_Success() {
        Inventory inventory = new Inventory();
        when(inventoryrepository.addInventory(inventory)).thenReturn("success");

        String result = inventoryserviceimpl.addInventory(inventory);

        assertEquals("success", result);
        verify(inventoryrepository, times(1)).addInventory(inventory);
    }

    @Test
    void testAddInventory_Failure() {
        String result = inventoryserviceimpl.addInventory(null);

        assertEquals("failure", result);
        verify(inventoryrepository, times(0)).addInventory(any(Inventory.class));
    }

//    @Test
//    void testUpdateInventory() {
//        Inventory inventory = new Inventory();
//        when(inventoryrepository.updtae(inventory)).thenReturn("Success");
//
//        String result = inventoryserviceimpl.updateInventory(inventory);
//
//        assertEquals("Success", result);
//        verify(inventoryrepository, times(1)).updtae(inventory);
//    }
//
//    @Test
//    void testDeleteInventory() {
//        int id = 1;
//        when(inventoryrepository.delete(id)).thenReturn("success");
//
//        String result = inventoryserviceimpl.deleteInventory(id);
//
//        assertEquals("success", result);
//        verify(inventoryrepository, times(1)).delete(id);
//    }

    @Test
    void testFindAllInventories() {
        Inventory inventory = new Inventory();
        when(inventoryrepository.findAllInventories()).thenReturn(Collections.singletonList(inventory));

        List<Inventory> result = inventoryserviceimpl.findAllInventories();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(inventory, result.get(0));
        verify(inventoryrepository, times(1)).findAllInventories();
    }

    @Test
    void testFindInventoryById() {
        Inventory inventory = new Inventory();
        int id = 1;
        when(inventoryrepository.findById(id)).thenReturn(inventory);

        Inventory result = inventoryserviceimpl.findInventoryById(id);

        assertNotNull(result);
        assertEquals(inventory, result);
        verify(inventoryrepository, times(1)).findById(id);
    }
}

