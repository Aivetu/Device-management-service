package com.nimisi.device_management_service.model;

import com.nimisi.device_management_service.enums.DeviceType;

public class AddDeviceModel {
    private String username;
    private String device_id;
    private String device_name;
    private DeviceType device_type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public DeviceType getDevice_type() {
        return device_type;
    }

    public void setDevice_type(DeviceType device_type) {
        this.device_type = device_type;
    }
}
