package ru.university.equiprent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.university.equiprent.model.EquipmentCategory;
import ru.university.equiprent.repository.EquipmentCategoryRepository;

@Service
@RequiredArgsConstructor
public class EquipmentCategoryService {

    private final EquipmentCategoryRepository repository;

    public List<EquipmentCategory> findAll() {
        return repository.findAll();
    }

    public EquipmentCategory create(EquipmentCategory category) {
        return repository.save(category);
    }
}
