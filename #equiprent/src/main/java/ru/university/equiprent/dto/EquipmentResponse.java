package ru.university.equiprent.dto;

import java.math.BigDecimal;

import ru.university.equiprent.model.EquipmentStatus;

public record EquipmentResponse(
    Long id,
    String title,
    BigDecimal dailyRate,
    EquipmentStatus status
) {

}
