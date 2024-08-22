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

import com.mb.model.ProductList;
import com.mb.repo.ProductListRepository;

class ProductListServiceImplTest {

    @InjectMocks
    private ProductListServiceImpl productlistserviceimpl;

    @Mock
    private ProductListRepository productlistrepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddProduct_Success() {
        ProductList product = new ProductList();
        when(productlistrepository.addProduct(product)).thenReturn("success");

        String result = productlistserviceimpl.addProduct(product);

        assertEquals("success", result);
        verify(productlistrepository, times(1)).addProduct(product);
    }

    @Test
    void testAddProduct_Failure() {
        String result = productlistserviceimpl.addProduct(null);

        assertEquals("failure", result);
        verify(productlistrepository, times(0)).addProduct(any(ProductList.class));
    }

//    @Test
//    void testUpdateProduct() {
//        ProductList product = new ProductList();
//        when(productlistrepository.update(product)).thenReturn("Success");
//
//        String result = productlistserviceimpl.updateProduct(product);
//
//        assertEquals("Success", result);
//        verify(productlistrepository, times(1)).update(product);
//    }
//
//    @Test
//    void testDeleteProduct() {
//        int id = 1;
//        when(productlistrepository.delete(id)).thenReturn("success");
//
//        String result = productlistserviceimpl.deleteProduct(id);
//
//        assertEquals("success", result);
//        verify(productlistrepository, times(1)).delete(id);
//    }

    @Test
    void testFindAllProducts() {
        ProductList product = new ProductList();
        when(productlistrepository.findAllProducts()).thenReturn(Collections.singletonList(product));

        List<ProductList> result = productlistserviceimpl.findAllProducts();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(product, result.get(0));
        verify(productlistrepository, times(1)).findAllProducts();
    }

    @Test
    void testFindProductById() {
        ProductList product = new ProductList();
        int id = 1;
        when(productlistrepository.findById(id)).thenReturn(product);

        ProductList result = productlistserviceimpl.findProductById(id);

        assertNotNull(result);
        assertEquals(product, result);
        verify(productlistrepository, times(1)).findById(id);
    }
}

