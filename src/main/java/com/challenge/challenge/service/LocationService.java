package com.challenge.challenge.service;

import com.challenge.challenge.dto.LocationDTO;

import java.util.List;

public interface LocationService {

    List<LocationDTO> getAllLocations();
    public LocationDTO searchById(Long id);

    public LocationDTO saveLocation(LocationDTO locationDTO);
    public LocationDTO updateLocation(LocationDTO locationDTO, Long id);

    public void deleteLocation(Long id);
}
