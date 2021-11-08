package com.skillstorm.telecom.controllers;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.telecom.beans.Device;
import com.skillstorm.telecom.services.DeviceService;

@RestController
@RequestMapping("telecom/v1")
@CrossOrigin(origins = "https://telecom-angular-tw.azurewebsites.net") // allow requests from a specified host ??
public class DeviceController {

	@Autowired
	DeviceService service;
	
	// Logging level: Trace, Debug, Info, Warn, Error, and Fatal
	Logger log = Logger.getLogger(DeviceController.class);
	
	@GetMapping
	public ResponseEntity<List<Device>> findAllDevices() {
		
		log.info("findAllDevices() was called");
		List<Device> allDevices = service.findAll();
		
		return new ResponseEntity<>(allDevices, HttpStatus.OK);
	}
	
	@PostMapping("device")
	public ResponseEntity<Device> saveDevice(@RequestBody Device device) {
		
		log.info("saveDevice() was called");
		Device newDevice = service.save(device);
		
		return new ResponseEntity<>(newDevice, HttpStatus.CREATED);
	}
	
	/* updateDevice() implementation */
	
//	
//	@DeleteMapping
//	public ResponseEntity<Device> deleteDevice(@RequestBody Device device) {
//		
//		service.delete(device);
//		
//		return new ResponseEntity<>(device, HttpStatus.OK);
//	}
	
	@PutMapping("device")
	public ResponseEntity<Device> updatePhoneNumber(@RequestBody Device device) {
		
		int deviceId = device.getDeviceId();
		String deviceNumber = device.getDeviceNumber();
		
		log.info("updatePhoneNumber() was called");
		service.updatePhoneNumber(deviceId, deviceNumber);
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("devices")
	public ResponseEntity<Device> batchCreate(@RequestBody List<Device> devices) {
		log.info("batchCreate() was called");
		service.batchCreate(devices);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("devices/{planId}")
	public ResponseEntity<Device> batchDelete(@PathVariable int planId) {
		log.info("batchDelete() was called");
		service.batchDelete(planId);
		return new ResponseEntity<>(HttpStatus.GONE);
	}
}
