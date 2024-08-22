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

import com.mb.model.Category;
import com.mb.repo.CategoryRepository;

class CategoryServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl categoryserviceimpl;

    @Mock
    private CategoryRepository categoryrepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddCategory_Success() {
        Category category = new Category();
        when(categoryrepository.addCategory(any(Category.class))).thenReturn("success");

        String result = categoryserviceimpl.addCategory(category);

        assertEquals("success", result);
        verify(categoryrepository, times(1)).addCategory(any(Category.class));
    }

    @Test
    void testAddCategory_Failure() {
        String result = categoryserviceimpl.addCategory(null);

        assertEquals("failure", result);
        verify(categoryrepository, times(0)).addCategory(any(Category.class));
    }

//    @Test
//    void testUpdateCategory() {
//        Category category = new Category();
//        doNothing().when(categoryrepository).update(any(Category.class));
//
//        String result = categoryserviceimpl.updateCategory(category);
//
//        assertEquals("Success", result);
//        verify(categoryrepository, times(1)).update(any(Category.class));
//    }

//    @Test
//    void testDeleteCategory() {
//        int categoryId = 1;
//        when(categoryrepository.delete(categoryId)).thenReturn("Success");
//
//        String result = categoryserviceimpl.deleteCategory(categoryId);
//
//        assertEquals("Success", result);
//        verify(categoryrepository, times(1)).delete(categoryId);
//    }

    @Test
    void testFindAllCategories() {
        Category category = new Category();
        when(categoryrepository.findAllCategories()).thenReturn(Collections.singletonList(category));

        List<Category> result = categoryserviceimpl.findAllCategories();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        verify(categoryrepository, times(1)).findAllCategories();
    }

    @Test
    void testFindCategoryById() {
        Category category = new Category();
        category.setCategoryId(1);
        when(categoryrepository.findById(1)).thenReturn(category);

        Category result = categoryserviceimpl.findCategoryById(1);

        assertNotNull(result);
        assertEquals(1, result.getCategoryId());
        verify(categoryrepository, times(1)).findById(1);
    }
}
