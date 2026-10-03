package ru.university.equiprent.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EquipmentRequest(
    @NotBlank(message = "Title cannot be blank") String title,
    @NotNull(message = "dailyRate cannnot be Null or Empty")  
    @DecimalMin(value = "0.01", 
    message = "dailyRate cannot be lower then 0")
    BigDecimal dailyRate,

    @NotNull (message = "categoryId cannot be Null or Empty")
    Long categoryId,

    String serialNumber
) {

}
