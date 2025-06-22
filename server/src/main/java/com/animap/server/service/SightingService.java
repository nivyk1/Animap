package com.animap.server.service;

import com.animap.server.entity.Sighting;
import com.animap.server.repository.SightingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightingService {

    private final SightingRepository sightingRepository;

    public SightingService(SightingRepository sightingRepository) {
        this.sightingRepository = sightingRepository;
    }

    public List<Sighting> findAllSightings() {
        return sightingRepository.findAll();
    }

    public Sighting saveSighting(Sighting sighting) {
        return sightingRepository.save(sighting);
    }

    public void deleteSighting(Long sightingId) {
        sightingRepository.deleteById(sightingId);
    }
}
