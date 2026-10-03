package ru.university.equiprent.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import ru.university.equiprent.dto.EquipmentRequest;
import ru.university.equiprent.dto.EquipmentResponse;

@RequestMapping("/api/equipment")
@Tag(name = "Equipment Controller")
public interface EquipmentApi {
        @GetMapping()
        public List<EquipmentResponse> getAll();

        @GetMapping("/{id}")
        public EquipmentResponse get(
                        @RequestParam Long id);

        @PostMapping
        public EquipmentResponse create(
                        @RequestBody @Valid EquipmentRequest entity);

        @PutMapping 
        public EquipmentResponse update(
                        @RequestBody @Valid EquipmentRequest entity, Long id);

        @DeleteMapping 
        public ResponseEntity<Void> delete(Long id);
}
