package dev.cat.customer.mapper;
import dev.cat.customer.dto.CustomerResponse;
import dev.cat.customer.dto.OrderResponse;
import dev.cat.customer.entity.Customer;
import dev.cat.customer.entity.Status;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Objects;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        componentModel = "spring")
public abstract class CustomerMapper {


    public CustomerResponse mapToCustomerResponse(Customer customer) {

        List<OrderResponse> orderResponses = customer.getOrders()
                .stream()
                .filter(Objects::nonNull)
                .map(OrderMapper.INSTANCE::mapToOrderResponse)
                .toList();

        double totalExpenses = orderResponses.stream()
                .filter(Objects::nonNull)
                .map(OrderResponse::totalPrice)
                .reduce(0.0, Double::sum);

        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                statusToString(customer.getStatus()),
                orderResponses,
                totalExpenses);
    }

    private String statusToString(Status status) {
        return status.name();
    }
}
