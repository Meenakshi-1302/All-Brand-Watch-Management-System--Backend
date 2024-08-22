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

import com.mb.model.Feedback;
import com.mb.repo.FeedbackRepository;

class FeedbackServiceImplTest {

    @InjectMocks
    private FeedbackServiceImpl feedbackserviceimpl;

    @Mock
    private FeedbackRepository feedbackrepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddFeedback_Success() {
        Feedback feedback = new Feedback();
        when(feedbackrepository.addFeedback(feedback)).thenReturn("success");

        String result = feedbackserviceimpl.addFeedback(feedback);

        assertEquals("success", result);
        verify(feedbackrepository, times(1)).addFeedback(feedback);
    }

    @Test
    void testAddFeedback_Failure() {
        when(feedbackrepository.addFeedback(null)).thenReturn("failure");

        String result = feedbackserviceimpl.addFeedback(null);

        assertEquals("failure", result);
        verify(feedbackrepository, times(0)).addFeedback(any(Feedback.class));
    }

//    @Test
//    void testUpdateFeedback() {
//        Feedback feedback = new Feedback();
//        when(feedbackrepository.updtae(feedback)).thenReturn("success");
//
//        String result = feedbackserviceimpl.updateFeedback(feedback);
//
//        assertEquals("Success", result);
//        verify(feedbackrepository, times(1)).updtae(feedback);
//    }
//
//    @Test
//    void testDeleteFeedback() {
//        int id = 1;
//        when(feedbackrepository.delete(id)).thenReturn("success");
//
//        String result = feedbackserviceimpl.deleteFeedback(id);
//
//        assertEquals("success", result);
//        verify(feedbackrepository, times(1)).delete(id);
//    }

    @Test
    void testFindAllFeedbacks() {
        Feedback feedback = new Feedback();
        when(feedbackrepository.findAllFeedbacks()).thenReturn(Collections.singletonList(feedback));

        List<Feedback> result = feedbackserviceimpl.findAllFeedbacks();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(feedback, result.get(0));
        verify(feedbackrepository, times(1)).findAllFeedbacks();
    }

    @Test
    void testFindFeedbackById() {
        Feedback feedback = new Feedback();
        int id = 1;
        when(feedbackrepository.findById(id)).thenReturn(feedback);

        Feedback result = feedbackserviceimpl.findFeedbackById(id);

        assertNotNull(result);
        assertEquals(feedback, result);
        verify(feedbackrepository, times(1)).findById(id);
    }
}
