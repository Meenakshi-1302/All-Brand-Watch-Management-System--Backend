package com.mb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.model.Watch;
import com.mb.repo.WatchRepository;
import com.mb.service.WatchService;


@Service
public class WatchServiceImpl implements WatchService {
	@Autowired
	WatchRepository watchrepository;

	@Override
	public String addWatch(Watch watch) {
		if(watch!=null) {
			watchrepository.addWatch(watch);
			 return "success";
			}else {
				return "failure";
			}
	}

	@Override
	public String updateWatch(Watch watch) {
		watchrepository.update(watch);
		System.out.println("Watch service");
		return "Success";
	}

	@Override
	public String deleteWatch(int id) {
		return watchrepository.delete(id);
	}

	@Override
	public List<Watch> findAllWatchs() {
		return watchrepository.findAllWatches();
	}

	@Override
	public Watch findWatchById(int id) {
		return watchrepository.findById(id);
	}

	public byte[] getWatchImage(int watchId) {
        // Fetch the watch entity by ID
        Watch watch = watchrepository.findById(watchId);

        if (watch != null) {
            // Return the image bytes
            return watch.getImageUrl();
        } else {
            // Return null or handle the case where the watch does not exist
            return null;
        }
    }

}
