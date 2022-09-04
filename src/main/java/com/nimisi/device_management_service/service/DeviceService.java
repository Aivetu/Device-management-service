package com.nimisi.device_management_service.service;

import com.nimisi.device_management_service.exception.DeviceException;
import com.nimisi.device_management_service.model.AddDeviceModel;
import com.nimisi.device_management_service.model.DeviceModel;
import com.nimisi.device_management_service.repo.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {
    @Autowired
    DeviceRepo deviceRepo;

    public List<DeviceModel> getDeviceList(){
        return deviceRepo.findAll();
    }

    public String addNewDevice(AddDeviceModel addDeviceModel){
        Optional<DeviceModel> device = deviceRepo.findByUsernameAndAuthoriseTrue(addDeviceModel.getUsername());
        if(!device.isPresent()){
            DeviceModel add = new DeviceModel();
            add.setAuthorise(true);
            add.setDeviceId(addDeviceModel.getDevice_id());
            add.setBlocked(false);
            add.setDevice_type(addDeviceModel.getDevice_type());
            add.setDevice_name(addDeviceModel.getDevice_name());
            add.setUsername(addDeviceModel.getUsername());
            add.setCreated_at(LocalDateTime.now());
            deviceRepo.save(add);
        } else throw new DeviceException("Device already exist");

        return "New Device Created Successfully";


    }

    public String loginDevice(String username,String deviceId) {
        Optional<DeviceModel> device = deviceRepo.findByUsernameAndDeviceIdAndAuthoriseTrue(username, deviceId);
        Optional<DeviceModel> ifBlocked = deviceRepo.findByBlockedFalse();

        if (device.isPresent()) {
            if (ifBlocked.isPresent()) {
                device.get().setLast_login(LocalDateTime.now());
                deviceRepo.save(device.get());
            } else {
                throw new DeviceException("This device has been blocked,contact Customer support");
            }
            throw new DeviceException("Incorrect Details");


        }
        return "Login Successful";
    }
    public String deleteDevice(String username,String deviceId) {
        Optional<DeviceModel> device = deviceRepo.findByUsernameAndDeviceIdAndAuthoriseTrue(username, deviceId);
        Optional<DeviceModel> ifBlocked = deviceRepo.findByBlockedFalse();

        if (device.isPresent()) {
            if (ifBlocked.isPresent()) {
                device.get().setAuthorise(false);
                deviceRepo.delete(device.get());
            } else
            {throw new DeviceException("This device is Blocked");}
            throw new DeviceException("Incorrect Details");

        }
        return "Device has been Deactivated";
    }
}
