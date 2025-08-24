package dev.cat.device.repository;

import dev.cat.device.dto.DeviceDTO;
import dev.cat.device.dto.DeviceDTOwithManufacturerDTO;
import dev.cat.device.dto.DeviceDTOwithManufacturerName;
import dev.cat.device.entity.Device;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long>, CustomDeviceRepository {

    <T> Collection<T> findByLotNumber(int lotNumber, Class<T> type);

    @Query("""
               select new dev.cat.device.dto.DeviceDTOwithManufacturerName(
                           d.serialNumber, d.model, d.manufacturer.name)
               from Device d
               where d.lotNumber = :lotNumber
            """)
    List<DeviceDTOwithManufacturerName> findByLotNumberWithManufacturerName(int lotNumber);

    @Query("""
               select new dev.cat.device.dto.DeviceDTOwithManufacturerDTO(
                 d.serialNumber, d.model,
                 new dev.cat.device.dto.ManufacturerDTO(m.id, m.name)
               )
               from Device d
               join d.manufacturer m
               where d.lotNumber = :lotNumber
            """)
    List<DeviceDTOwithManufacturerDTO> findByLotNumberNested(int lotNumber);


    @Query("SELECT d.serialNumber, d.model FROM Device d WHERE d.lotNumber = :lotNumber")
    List<DeviceDTO> findByLotNumber(int lotNumber);


}
