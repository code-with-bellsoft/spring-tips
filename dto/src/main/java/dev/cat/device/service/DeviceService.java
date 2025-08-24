package dev.cat.device.service;

import dev.cat.device.dto.DeviceDTO;
import dev.cat.device.entity.Device;
import dev.cat.device.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    void doSomethingMeaningful(int lotNumber) {

        Collection<Device> devices =
                deviceRepository.findByLotNumber(123456, Device.class);

        Collection<DeviceDTO> deviceDtos =
                deviceRepository.findByLotNumber(123456, DeviceDTO.class);
    }


}
