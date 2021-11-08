package com.skillstorm.telecom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.telecom.beans.Device;
import com.skillstorm.telecom.data.DeviceRepository;

@Service
public class DeviceService {

	@Autowired
	DeviceRepository repo;

	public List<Device> findAll() {
		return repo.findAll();
	}

	public Device save(Device device) {
		return repo.save(device);
	}

//	public void delete(Device device) {
//		repo.delete(device);
//	}

	@Transactional
	public void updatePhoneNumber(int deviceId, String deviceNumber) {
		repo.updatePhoneNumber(deviceId, deviceNumber);
	}


	@Transactional
	public void batchCreate(List<Device> devices) {
		for (Device device : devices) {
			String deviceNumber = device.getDeviceNumber();
			int planId = device.getPlanId();
			int planNumber = device.getPlanNumber();
			int planCost = device.getPlanCost();

			repo.batchCreate(deviceNumber, planId, planNumber, planCost);
		}
	}

	@Transactional
	public void batchDelete(int planId) {
		repo.batchDelete(planId);
	}
}
