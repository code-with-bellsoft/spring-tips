package dev.cat.device.repository;

import dev.cat.device.entity.Device;

public interface CustomDeviceRepository {
    Device findByIdWithFetchGraph(Long id);
    Device findByIdWithLoadGraph(Long id);
    Device findByIdWithoutGraph(Long id);
}
