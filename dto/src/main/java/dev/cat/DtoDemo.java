package dev.cat;

import dev.cat.device.repository.DeviceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DtoDemo implements CommandLineRunner {

    private final DeviceRepository deviceRepository;

    public DtoDemo(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DtoDemo.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Device fetched without graph:");
        deviceRepository.findByIdWithoutGraph(1L);
        System.out.println("Device fetched with fetch graph:");
        deviceRepository.findByIdWithFetchGraph(1L);
        System.out.println("Device fetched with load graph:");
        deviceRepository.findByIdWithLoadGraph(1L);

    }
}