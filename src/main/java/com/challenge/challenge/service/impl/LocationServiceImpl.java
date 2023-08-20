package com.challenge.challenge.service.impl;

import com.challenge.challenge.dto.LocationDTO;
import com.challenge.challenge.entities.Location;
import com.challenge.challenge.exceptions.ResourceNotFoundException;
import com.challenge.challenge.repository.LocationRepository;
import com.challenge.challenge.service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository, ModelMapper modelMapper) {
        this.locationRepository = locationRepository;
        this.modelMapper = modelMapper;
    }

    public List<LocationDTO> getAllLocations() {
        return locationRepository.findAll().stream().map(this::mapDTO).collect(Collectors.toList());
    }

    public LocationDTO searchById(Long id) {
        return mapDTO(locationRepository.findById(id).get());
    }

    public LocationDTO saveLocation(LocationDTO locationDTO) {
        return mapDTO(locationRepository.save(mapEntity(locationDTO)));
    }

    public LocationDTO updateLocation(LocationDTO locationDTO, Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location", "id", id));
        location.setDimension(locationDTO.getDimension());
        location.setName(locationDTO.getName());
        return mapDTO(locationRepository.save(location));
    }

    public void deleteLocation(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location", "id", id));
        locationRepository.delete(location);
    }

    private Location mapEntity(LocationDTO locationDTO) {
        return modelMapper.map(locationDTO, Location.class);
    }

    private LocationDTO mapDTO(Location location) {
        return modelMapper.map(location, LocationDTO.class);
    }
}
