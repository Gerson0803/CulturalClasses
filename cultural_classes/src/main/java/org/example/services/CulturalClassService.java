/*package org.example.services;

import lombok.extern.slf4j.Slf4j;
import  org.example.dto.CreateCulturalDto;
import org.example.domain.CulturalClass;
import org.example.repositories.CulturalClassRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class CulturalClassService {
    private final CulturalClassRepository repository;
    public CulturalClassService(CulturalClassRepository repository) {
        this.repository = repository;
    }

    public CulturalClass create(CreateCulturalDto dto) {
        log.info("Creating CulturalClass: {}", dto);

        validateName(dto.name());
        validateCapacity(dto.maxCapacity());
        validateDates(dto.startDateTime(), dto.endDateTime());

        CulturalClass culturalClass = CulturalClass.builder()
                .name(dto.name())
                .category(dto.category())
                .maxCapacity(dto.maxCapacity())
                .startDateTime(dto.startDateTime().toEpochDay())
                .endDateTime(dto.endDateTime().toEpochSecond(java.time.ZoneOffset.UTC))
                .available(true)
                .build();

        return repository.save(culturalClass);
    }

    private void validateName(String name) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 characters");
        }
        if (repository.existsByName(name)) {
            throw new IllegalArgumentException("Name must be unique");
        }
    }

    private void validateCapacity(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Max capacity must be greater than 0");
        }
    }

    private void validateDates(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Start and end dates are required");
        }
        if (!end.isAfter(start)) {
            throw new IllegalArgumentException("End date must be after start date");
        }
    }

    public List<CulturalClass> findAll() {
        return repository.findAll();
    }
}
*/