package ru.university.equiprent.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.university.equiprent.api.EquipmentApi;
import ru.university.equiprent.dto.EquipmentRequest;
import ru.university.equiprent.dto.EquipmentResponse;
import ru.university.equiprent.service.EquipmentService;

@RequiredArgsConstructor
@RestController
public class EquipmentController implements EquipmentApi {
    private final EquipmentService service;

    public List<EquipmentResponse> getAll() {
        return service.findAll();
    }

    public EquipmentResponse get(Long id) {
        return service.findById(id);
    }

    public EquipmentResponse create(EquipmentRequest request) {
        return service.create(request);
    }

    public EquipmentResponse update(EquipmentRequest request, Long id) {
        return service.update(request, id);
    }

    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
