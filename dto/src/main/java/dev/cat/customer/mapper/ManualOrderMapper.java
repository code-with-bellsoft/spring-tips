package dev.cat.customer.mapper;

import dev.cat.customer.dto.OrderRequest;
import dev.cat.customer.entity.Customer;
import dev.cat.customer.entity.Order;
import jakarta.persistence.EntityManager;

public class ManualOrderMapper {

    private final EntityManager entityManager;

    public ManualOrderMapper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Order toOrder(Long customerId, OrderRequest request) {
        Order order = new Order();
        order.setCustomer(entityManager.getReference(Customer.class, customerId));
        order.setTotalPrice(request.totalPrice());
        return order;
    }
}
