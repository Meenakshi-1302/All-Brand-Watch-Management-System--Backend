package com.mb.repoimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mb.model.Watch;
import com.mb.repo.WatchRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class WatchRepositoryImpl implements WatchRepository {
	
	@Autowired
	EntityManager em;


	@Override
	public String addWatch(Watch watch) {
		if(watch!=null) {
		em.merge(watch);
		return "success";
		}
		else {
			return "insertion failed";
		}
		
	}

	@Override
	public String update(Watch watch) {
		if(watch!=null) {
			em.merge(watch);
			return"success";
		}
		else {
			return "failure";
		}
		
	}

	@Override
	public String delete(int watch_id) {
		
		Watch id = em.find(Watch.class,watch_id);
		em.remove(id);
		return "deleted";
		
	}

	@Override
	public List<Watch> findAllWatches() {
		String hql = "from Watch";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Watch findById(int watch_id) {
		return em.find(Watch.class, watch_id);
	}

}
