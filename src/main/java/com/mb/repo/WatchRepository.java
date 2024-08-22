package com.mb.repo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mb.model.Watch;

public interface WatchRepository {
	
	public String addWatch(Watch watch);
	public String update(Watch watch);
	public String delete(int watch_id);
	public List<Watch> findAllWatches();
	public Watch findById(int watch_id);

}
