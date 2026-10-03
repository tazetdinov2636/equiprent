package ru.university.equiprent.repository;

import java.util.List;
import java.util.Optional;

import ru.university.equiprent.model.Equipment;

public interface EquipmentDao {
    Equipment save(Equipment equipment);
    Equipment update(Equipment equipment, Long id);
    List<Equipment> findAll();
    void delete(Long id);
    Optional<Equipment> findById(Long id);
}
