package dev.cat.customer.dto;

public record CustomerRequest(String name,
                              String email,
                              String password) {
}
