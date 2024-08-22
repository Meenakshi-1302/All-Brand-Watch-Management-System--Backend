package com.mb.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mb.model.Watch;

public interface WatchService {
	public String addWatch(Watch watch);
	public String updateWatch(Watch watch);
	public String deleteWatch(int id);
	public List<Watch> findAllWatchs();
	public Watch findWatchById(int id);

}
