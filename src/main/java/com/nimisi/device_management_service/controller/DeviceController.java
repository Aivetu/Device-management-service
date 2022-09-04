package com.nimisi.device_management_service.controller;

import com.nimisi.device_management_service.model.AddDeviceModel;
import com.nimisi.device_management_service.model.DeviceModel;
import com.nimisi.device_management_service.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/device")
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @GetMapping("/get")
    public List<DeviceModel> getDevice(){
        return deviceService.getDeviceList();
    }

    @PostMapping("/add")
    public String addDevice(@RequestBody AddDeviceModel addDeviceModel) {
        return deviceService.addNewDevice(addDeviceModel);
    }

    @PostMapping("/login")
    public String LoginDevice(@RequestBody String username,String device_id){
        return deviceService.loginDevice(username, device_id);
    }

    @DeleteMapping("/delete")
    public String deleteDevice(@RequestBody String username,String device_id){
        return deviceService.deleteDevice(username, device_id);
    }
}
