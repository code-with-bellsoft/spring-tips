package dev.cat.customer.mapper;

import dev.cat.customer.dto.CustomerRequest;
import dev.cat.customer.dto.CustomerResponse;
import dev.cat.customer.dto.OrderResponse;
import dev.cat.customer.entity.Customer;
import dev.cat.customer.entity.Order;
import dev.cat.customer.entity.Status;

import java.util.List;
import java.util.Objects;

public class ManualCustomerMapper {


    public CustomerResponse mapToCustomerResponse(Customer customer) {
        List<OrderResponse> orderResponses = customer.getOrders()
                .stream()
                .filter(Objects::nonNull)
                .map(this::mapToOrderResponse)
                .toList();

        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                statusToString(customer.getStatus()),
                orderResponses,
                orderResponses
                        .stream()
                        .filter(Objects::nonNull)
                        .map(OrderResponse::totalPrice)
                        .reduce(0.0, Double::sum));
    }

    private String statusToString(Status status) {
        return status.name();
    }

    public OrderResponse mapToOrderResponse(Order order) {
        return new OrderResponse(order.getId(), order.getTotalPrice());
    }

    public Customer mapToCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.name());
        customer.setEmail(customerRequest.email());
        customer.setPassword(customerRequest.password());
        customer.setStatus(Status.BRONZE);
        return customer;
    }


}
