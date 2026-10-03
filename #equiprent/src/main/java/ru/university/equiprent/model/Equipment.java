package ru.university.equiprent.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class Equipment {
    private Long id;
    private String title;
    private BigDecimal dailyRate;
    private EquipmentStatus status;
}
