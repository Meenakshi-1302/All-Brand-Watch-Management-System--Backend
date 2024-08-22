package com.mb.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mb.model.Watch;
import com.mb.serviceimpl.WatchServiceImpl;


@RestController
@RequestMapping("/watch")
@CrossOrigin("*")
public class WatchController {
	@Autowired
	WatchServiceImpl watchserviceimpl;
	@PostMapping
	public String insertWatch(@RequestBody Watch watch) {
		String msg="";
		try {
			watchserviceimpl.addWatch(watch);
			msg="Success";
		}
		catch(Exception e) {
			msg="Failure";
		}
		
		return msg;
		
	}
	@GetMapping("{watch_id}")
	public Watch getWatchById(@PathVariable("watch_id") int id) {
		return watchserviceimpl.findWatchById(id);
		
	}
	@GetMapping("/all")
	public List<Watch> getWatches(){
		return watchserviceimpl.findAllWatchs();
	}
	
	@PutMapping
	public String updateWatch(@RequestBody Watch watch) {
		String msg="";
		try {
			watchserviceimpl.updateWatch(watch);
			msg="Updated";
		}
		catch(Exception e) {
			msg="Not Updated";
		}
		return msg;
		
	}
	@DeleteMapping("{watch_id}")
	public String deleteWatch(@PathVariable("watch_id") int id) {
		String msg="";
		try {
			watchserviceimpl.deleteWatch(id);
			msg="Deleted";
		}
		catch(Exception e) {
			msg="Not Deleted";
		}
		return msg;
	}
	

}