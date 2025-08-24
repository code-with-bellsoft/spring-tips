package dev.cat.device.repository;

import dev.cat.device.entity.Device;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;

public class CustomDeviceRepositoryImpl implements CustomDeviceRepository {

    private final EntityManager entityManager;

    public CustomDeviceRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Device findByIdWithFetchGraph(Long id) {
        var entityGraph = entityManager.getEntityGraph("device-entity-graph");
        Map<String, Object> properties = new HashMap<>();
        properties.put("jakarta.persistence.fetchgraph", entityGraph);
        return entityManager.find(Device.class, id, properties);
    }

    @Override
    public Device findByIdWithLoadGraph(Long id) {
        var entityGraph = entityManager.getEntityGraph("device-entity-graph");
        Map<String, Object> properties = new HashMap<>();
        properties.put("jakarta.persistence.loadgraph", entityGraph);
        return entityManager.find(Device.class, id, properties);
    }

    @Override
    public Device findByIdWithoutGraph(Long id) {
        return entityManager.find(Device.class, id);
    }
}
