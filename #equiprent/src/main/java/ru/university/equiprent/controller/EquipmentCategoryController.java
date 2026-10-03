package ru.university.equiprent.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import ru.university.equiprent.model.EquipmentCategory;
import ru.university.equiprent.service.EquipmentCategoryService;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/equipment_category")
@Tag(name = "Equipment Category Controller")
public class EquipmentCategoryController {
    private final EquipmentCategoryService service;

    @GetMapping()
    public List<EquipmentCategory> getAll() {
        return service.findAll();
    }
    @PostMapping
    public EquipmentCategory create(@RequestBody EquipmentCategory request) {
        return service.create(request);
    }

}
