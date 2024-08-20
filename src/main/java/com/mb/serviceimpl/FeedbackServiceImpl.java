package com.mb.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.model.Feedback;
import com.mb.repo.FeedbackRepository;
import com.mb.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	
	@Autowired
	FeedbackRepository feedbackrepository;
	@Override
	public String addFeedback(Feedback feedback) {
		if(feedback!=null) {
			feedbackrepository.addFeedback(feedback);
			 return "success";
			}else {
				return "failure";
			}
	}

	@Override
	public String updateFeedback(Feedback feedback) {
		feedbackrepository.updtae(feedback);
		System.out.println("feedback service");
		return "Success";
	}

	@Override
	public String deleteFeedback(int id) {
		return feedbackrepository.delete(id);
	}

	@Override
	public List<Feedback> findAllFeedbacks() {
		return feedbackrepository.findAllFeedbacks();
	}

	@Override
	public Feedback findFeedbackById(int id) {
		return feedbackrepository.findById(id);
	}

}
