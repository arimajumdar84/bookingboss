package com.bookingboss.bookingbossjavatest.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ProductVO {
    @NotNull
    private String name;

    @Min(0)
    private int quantity;

    @JsonProperty("sale_amount")
    @Min(0)
    private int saleAmount;
}
