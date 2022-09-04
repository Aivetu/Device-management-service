package com.nimisi.device_management_service.model;

import com.nimisi.device_management_service.enums.DeviceType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "DeviceDetails")
public class DeviceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String deviceId;
    private String device_name;
    @Enumerated(EnumType.STRING)
    private DeviceType device_type;
    private Boolean authorise;
    private Boolean blocked;
    private LocalDateTime created_at;
    private LocalDateTime last_login;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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

    public Boolean getAuthorise() {
        return authorise;
    }

    public void setAuthorise(Boolean authorise) {
        this.authorise = authorise;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getLast_login() {
        return last_login;
    }

    public void setLast_login(LocalDateTime last_login) {
        this.last_login = last_login;
    }
}
