package com.challenge.challenge.controller;

import com.challenge.challenge.dto.LocationDTO;
import com.challenge.challenge.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping()
    public ResponseEntity<List<LocationDTO>> getAllLocations(){
        return ResponseEntity.ok(locationService.getAllLocations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> getLocationById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(locationService.searchById(id));
    }

    @PostMapping
    public ResponseEntity<LocationDTO> saveLocation(@RequestBody LocationDTO locationDTO){
        return ResponseEntity.ok(locationService.saveLocation(locationDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationDTO> updateLocation(@RequestBody LocationDTO locationDTO, @PathVariable(name = "id") Long id){
        return ResponseEntity.ok(locationService.updateLocation(locationDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id){
        locationService.deleteLocation(id);
        return ResponseEntity.ok("Location Delete");
    }
}
