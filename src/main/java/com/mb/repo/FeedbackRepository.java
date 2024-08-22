package com.mb.repo;

import java.util.List;
import com.mb.model.Feedback;

public interface FeedbackRepository {
	public String addFeedback(Feedback feedback);
	public String updtae(Feedback feedback);
	public String delete(int feedbackId);
	public List<Feedback> findAllFeedbacks();
	public Feedback findById(int feedbackId);

}
