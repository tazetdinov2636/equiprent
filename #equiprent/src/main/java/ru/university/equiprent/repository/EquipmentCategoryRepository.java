package ru.university.equiprent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.university.equiprent.model.EquipmentCategory;

public interface EquipmentCategoryRepository extends 
JpaRepository<EquipmentCategory, Long> {
List<EquipmentCategory> findByName(String name);
}
