package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Advertisement;
import com.masai.service.AdvertisementService;

@RestController
@RequestMapping(value = "/advertisement")
public class AdvertisementController {
	
	@Autowired
	private AdvertisementService advertisementService;
	
	@PostMapping(value = "/createAdvertisement")
	public ResponseEntity<Advertisement> createAdvertisement(@RequestBody Advertisement advertisement){
		return new ResponseEntity<Advertisement>(advertisementService.createAdvertisement(advertisement), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAdvertisementById/{advertisementId}")
	public ResponseEntity<Advertisement> getAdvertisementById(@PathVariable("advertisementId") Long advertisementId){
		return new ResponseEntity<Advertisement>(advertisementService.getAdvertisementById(advertisementId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/getAllAdvertisements")
	public ResponseEntity<List<Advertisement>> getAllAdvertisements(){
		return new ResponseEntity<List<Advertisement>>(advertisementService.getAllAdvertisements(), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/updateAdvertisement/{advertisementId}")
	public ResponseEntity<Advertisement> updateAdvertisement(@PathVariable("advertisementId") Long advertisementId, @RequestBody Advertisement advertisement){
		return new ResponseEntity<Advertisement>(advertisementService.updateAdvertisement(advertisementId, advertisement), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/deleteAdvertisement/{advertisementId}")
	public ResponseEntity<String> deleteAdvertisement(@PathVariable("advertisementId") Long advertisementId){
		return new ResponseEntity<String>(advertisementService.deleteAdvertisement(advertisementId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getActiveAdvertisements")
	public ResponseEntity<List<Advertisement>> getActiveAdvertisements(){
		return new ResponseEntity<List<Advertisement>>(advertisementService.getActiveAdvertisements(), HttpStatus.ACCEPTED);
	}

}
