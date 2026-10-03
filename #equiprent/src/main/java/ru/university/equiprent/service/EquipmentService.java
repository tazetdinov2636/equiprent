package ru.university.equiprent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.university.equiprent.dto.EquipmentRequest;
import ru.university.equiprent.dto.EquipmentResponse;
import ru.university.equiprent.model.Equipment;
import ru.university.equiprent.model.EquipmentCategory;
import ru.university.equiprent.model.EquipmentStatus;
import ru.university.equiprent.repository.EquipmentCategoryRepository;
import ru.university.equiprent.repository.EquipmentRepository;

@Service
@RequiredArgsConstructor
public class EquipmentService {
    private final EquipmentRepository repository;
    private final EquipmentCategoryRepository categoryRepository;

    public List<EquipmentResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public EquipmentResponse findById(Long id) {
        return toResponse(repository.findById(id).orElseThrow(() -> new RuntimeException("Equipment not found ")));
    }

    public EquipmentResponse create(EquipmentRequest request) {
        EquipmentCategory category = categoryRepository
        .findById(request.categoryId()).orElseThrow(() ->
        new RuntimeException("Category not found"));

        Equipment equipment = Equipment.builder()
                .title(request.title()).dailyRate(request.dailyRate())
                .category(category)
                .serialNumber(request.serialNumber())
                .status(EquipmentStatus.AVAILABLE)
                .build();

        return toResponse(repository.save(equipment));

    }

    private EquipmentResponse toResponse(Equipment equipment) {
        return new EquipmentResponse(equipment.getId(),
                equipment.getTitle(),
                equipment.getDailyRate(),
                equipment.getStatus(),
                equipment.getCategory().getName(),
                equipment.getSerialNumber());
    }

    public EquipmentResponse update(EquipmentRequest request, Long id) {
        Equipment equipment = repository.findById(id).orElseThrow(() -> new RuntimeException("Equipment not found "));
        equipment.setTitle(request.title());
        equipment.setDailyRate(request.dailyRate());
        equipment.setId(id);
        return toResponse(repository.save(equipment));
    
        
    }
    public void delete(Long id){
        Equipment equipment = repository.findById(id).orElseThrow(() -> new RuntimeException("Equipment not found "));
        repository.delete(equipment);
    
        
    }
}
