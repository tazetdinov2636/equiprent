package ru.university.equiprent.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import ru.university.equiprent.model.Equipment;
import ru.university.equiprent.service.IdGeneratorService;

@RequiredArgsConstructor
@Repository 
public class EquipmentRepository implements EquipmentDao {
    private final IdGeneratorService idGeneratorService;

    private final Map<Long, Equipment> storage = new ConcurrentHashMap<>();

    @Override
    public Equipment save(Equipment equipment) {
        if (equipment.getId() == null) {
            equipment.setId(idGeneratorService.next());
        }
        storage.put(equipment.getId(), equipment);
        return equipment;
    }

    @Override
    public List<Equipment> findAll() {
        return List.copyOf(storage.values());
    }

    @Override
    public Optional<Equipment> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public Equipment update(Equipment equipment, Long id) {
        storage.put(id, equipment);
        return storage.get(id);
    }

    @Override
    public void delete(Long id) {
        storage.remove(id);
    
    }

}
