package com.mb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mb.model.Feedback;
import com.mb.serviceimpl.FeedbackServiceImpl;


@CrossOrigin("*")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	FeedbackServiceImpl feedbackserviceimpl;
	@PostMapping
	public String insertInventory(@RequestBody Feedback feedback) {
		String msg="";
		try {
			feedbackserviceimpl.addFeedback(feedback);
			msg="Success";
		}
		catch(Exception e) {
			msg="Failure";
		}
		return msg;
		
	}
	@GetMapping("{feedbackId}")
	public Feedback getInventoryById(@PathVariable("feedbackId") int id) {
		return feedbackserviceimpl.findFeedbackById(id);
		
	}
	@GetMapping("/all")
	public List<Feedback> getFeedbacks(){
		return feedbackserviceimpl.findAllFeedbacks();
	}
	
	@PutMapping
	public String updateInventory(@RequestBody Feedback feedback) {
		String msg="";
		try {
			feedbackserviceimpl.updateFeedback(feedback);
			msg="Updated";
		}
		catch(Exception e) {
			msg="Not Updated";
		}
		return msg;
		
	}
	@DeleteMapping("{FeedbackId}")
	public String deleteFeedback(@PathVariable("FeedbackId") int id) {
		String msg="";
		try {
			feedbackserviceimpl.deleteFeedback(id);
			msg="Deleted";
		}
		catch(Exception e) {
			msg="Not Deleted";
		}
		return msg;
	}

}
