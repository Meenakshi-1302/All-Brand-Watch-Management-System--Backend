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

import com.mb.model.AdministrativeUser;
import com.mb.repo.AdministrativeUserRepository;

class AdministrativeUserServiceImplTest {

    @InjectMocks
    private AdministrativeUserServiceImpl administrativeuserserviceimpl;

    @Mock
    private AdministrativeUserRepository administrativeuserrepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveAdministrativeUser() {
        AdministrativeUser user = new AdministrativeUser();
        when(administrativeuserrepository.save(any(AdministrativeUser.class))).thenReturn(user);

        AdministrativeUser result = administrativeuserserviceimpl.saveAdministrativeUser(user);

        assertNotNull(result);
        assertEquals(user, result);
        verify(administrativeuserrepository, times(1)).save(any(AdministrativeUser.class));
    }

//    @Test
//    void testUpdateAdministrativeUser_Success() {
//        AdministrativeUser existingUser = new AdministrativeUser();
//        existingUser.setAdminUserId(1);
//        AdministrativeUser updatedUser = new AdministrativeUser();
//        updatedUser.setAdminUserId(1);
//        
//        when(administrativeuserrepository.findById(1)).thenReturn(existingUser);
//        when(administrativeuserrepository.save(updatedUser)).thenReturn(updatedUser);
//
//        AdministrativeUser result = administrativeuserserviceimpl.updateAdministrativeUser(updatedUser);
//
//        assertNotNull(result);
//        assertEquals(updatedUser, result);
//        verify(administrativeuserrepository, times(1)).findById(1);
//        verify(administrativeuserrepository, times(1)).save(updatedUser);
//    }
//
//    @Test
//    void testUpdateAdministrativeUser_Failure() {
//        AdministrativeUser updatedUser = new AdministrativeUser();
//        updatedUser.setAdminUserId(1);
//
//        when(administrativeuserrepository.findById(1)).thenReturn(null);
//
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            administrativeuserserviceimpl.updateAdministrativeUser(updatedUser);
//        });
//
//        assertEquals("AdministrativeUser with ID 1 does not exist.", exception.getMessage());
//        verify(administrativeuserrepository, times(1)).findById(1);
//        verify(administrativeuserrepository, times(0)).save(updatedUser);
//    }
//
//    @Test
//    void testDeleteAdministrativeUser_Success() {
//        int adminUserId = 1;
//        AdministrativeUser user = new AdministrativeUser();
//        user.setAdminUserId(adminUserId);
//
//        when(administrativeuserrepository.findById(adminUserId)).thenReturn(user);
//        doNothing().when(administrativeuserrepository).delete(adminUserId);
//
//        administrativeuserserviceimpl.deleteAdministrativeUser(adminUserId);
//
//        verify(administrativeuserrepository, times(1)).findById(adminUserId);
//        verify(administrativeuserrepository, times(1)).delete(adminUserId);
//    }
//
//    @Test
//    void testDeleteAdministrativeUser_Failure() {
//        int adminUserId = 1;
//
//        when(administrativeuserrepository.findById(adminUserId)).thenReturn(null);
//
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            administrativeuserserviceimpl.deleteAdministrativeUser(adminUserId);
//        });
//
//        assertEquals("AdministrativeUser with ID 1 does not exist.", exception.getMessage());
//        verify(administrativeuserrepository, times(1)).findById(adminUserId);
//        verify(administrativeuserrepository, times(0)).delete(adminUserId);
//    }

    @Test
    void testGetAdministrativeUserById() {
        AdministrativeUser user = new AdministrativeUser();
        int adminUserId = 1;
        when(administrativeuserrepository.findById(adminUserId)).thenReturn(user);

        AdministrativeUser result = administrativeuserserviceimpl.getAdministrativeUserById(adminUserId);

        assertNotNull(result);
        assertEquals(user, result);
        verify(administrativeuserrepository, times(1)).findById(adminUserId);
    }

    @Test
    void testGetAllAdministrativeUsers() {
        AdministrativeUser user = new AdministrativeUser();
        when(administrativeuserrepository.findAll()).thenReturn(Collections.singletonList(user));

        List<AdministrativeUser> result = administrativeuserserviceimpl.getAllAdministrativeUsers();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(user, result.get(0));
        verify(administrativeuserrepository, times(1)).findAll();
    }
}
