package com.animap.server.controller;

import com.animap.server.entity.Sighting;
import com.animap.server.service.SightingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sightings")
public class SightingController {

    private final SightingService sightingService;

    public SightingController(SightingService sightingService) {
        this.sightingService = sightingService;
    }

    @GetMapping
    public ResponseEntity<List<Sighting>> getAllSightings() {
        return ResponseEntity.ok(sightingService.findAllSightings());
    }

    @PostMapping
    public ResponseEntity<Sighting> createSighting(@RequestBody Sighting sighting) {
        return ResponseEntity.ok(sightingService.saveSighting(sighting));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSighting(@PathVariable Long id) {
        sightingService.deleteSighting(id);
        return ResponseEntity.noContent().build();
    }
}
