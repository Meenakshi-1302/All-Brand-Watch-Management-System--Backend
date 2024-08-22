package com.mb.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mb.model.Feedback;
import com.mb.model.Watch;
import com.mb.repo.FeedbackRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FeedbackRepositoryImpl implements FeedbackRepository {
	
	@Autowired
	EntityManager em;

	@Override
	public String addFeedback(Feedback feedback) {
		if(feedback!=null) {
			em.merge(feedback);
			return "success";
			}
			else {
				return "insertion failed";
			}
	}

	@Override
	public String updtae(Feedback feedback) {
		if(feedback!=null) {
			em.merge(feedback);
			return"success";
		}
		else {
			return "failure";
		}
	}

	@Override
	public String delete(int feedbackId) {
		Feedback id = em.find(Feedback.class,feedbackId);
		em.remove(id);
		return "deleted";
		
	}

	@Override
	public List<Feedback> findAllFeedbacks() {
		String hql = "from Feedback";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Feedback findById(int feedbackId) {
		return em.find(Feedback.class, feedbackId);
	}

}
