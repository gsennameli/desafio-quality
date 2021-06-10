package com.example.desafioQuality.services;

import com.example.desafioQuality.dtos.PropertyDTO;
import com.example.desafioQuality.models.Property;

public interface PropertyService {
    double getTotalSquareMeters(PropertyDTO propertyDTO);
}
