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

import com.mb.model.Supplier;
import com.mb.repo.SupplierRepository;

class SupplierServiceImplTest {

    @InjectMocks
    private SupplierServiceImpl supplierService;

    @Mock
    private SupplierRepository supplierRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddSupplier_Success() {
        Supplier supplier = new Supplier();
        when(supplierRepository.addSupplier(supplier)).thenReturn("success");

        String result = supplierService.addSupplier(supplier);

        assertEquals("success", result);
        verify(supplierRepository, times(1)).addSupplier(supplier);
    }

    @Test
    void testAddSupplier_Failure() {
        String result = supplierService.addSupplier(null);

        assertEquals("failure", result);
        verify(supplierRepository, times(0)).addSupplier(any(Supplier.class));
    }

    @Test
    void testUpdateSupplier() {
        Supplier supplier = new Supplier();
        when(supplierRepository.update(supplier)).thenReturn("Success");

        String result = supplierService.updateSupplier(supplier);

        assertEquals("Success", result);
        verify(supplierRepository, times(1)).update(supplier);
    }

    @Test
    void testDeleteSupplier() {
        int id = 1;
        when(supplierRepository.delete(id)).thenReturn("success");

        String result = supplierService.deleteSupplier(id);

        assertEquals("success", result);
        verify(supplierRepository, times(1)).delete(id);
    }

    @Test
    void testFindAllSuppliers() {
        Supplier supplier = new Supplier();
        when(supplierRepository.findAllSuppliers()).thenReturn(Collections.singletonList(supplier));

        List<Supplier> result = supplierService.findAllSuppliers();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(supplier, result.get(0));
        verify(supplierRepository, times(1)).findAllSuppliers();
    }

    @Test
    void testFindSupplierById() {
        Supplier supplier = new Supplier();
        int id = 1;
        when(supplierRepository.findById(id)).thenReturn(supplier);

        Supplier result = supplierService.findSupplerById(id);

        assertNotNull(result);
        assertEquals(supplier, result);
        verify(supplierRepository, times(1)).findById(id);
    }
}
