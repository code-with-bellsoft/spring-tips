package dev.cat.customer.dto;

import java.util.List;

public record CustomerResponse(Long id,
                               String name,
                               String email,
                               String status,
                               List<OrderResponse> orders,
                               double totalExpenses) {
}
















