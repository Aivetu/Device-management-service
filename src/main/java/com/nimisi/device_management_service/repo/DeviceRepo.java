package com.nimisi.device_management_service.repo;

import com.nimisi.device_management_service.model.DeviceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepo extends JpaRepository<DeviceModel,Long> {
    Optional<DeviceModel> findByUsernameAndAuthoriseTrue(String username);
    Optional<DeviceModel> findByUsernameAndDeviceIdAndAuthoriseTrue(String username, String deviceId);
    Optional<DeviceModel> findByBlockedFalse();
}
