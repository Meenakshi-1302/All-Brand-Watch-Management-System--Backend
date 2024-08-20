package com.mb.service;

import java.util.List;
import com.mb.model.Feedback;

public interface FeedbackService {
	public String addFeedback(Feedback feedback);
	public String updateFeedback(Feedback feedback);
	public String deleteFeedback(int id);
	public List<Feedback> findAllFeedbacks();
	public Feedback findFeedbackById(int id);

}
