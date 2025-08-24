package dev.cat.device.dto;

public record DeviceDTOwithManufacturerDTO(String serialNumber,
                                           String model,
                                           ManufacturerDTO manufacturer) {
}
