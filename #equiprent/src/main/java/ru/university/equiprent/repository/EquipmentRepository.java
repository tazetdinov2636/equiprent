package ru.university.equiprent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.university.equiprent.model.Equipment;



public interface EquipmentRepository extends 
        JpaRepository<Equipment, Long> {
    boolean existsBySerialNumber(String serialNumber);

    
} 