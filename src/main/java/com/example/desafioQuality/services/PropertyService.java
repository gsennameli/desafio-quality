package com.example.desafioQuality.services;

import com.example.desafioQuality.dtos.PropertyDTO;
import com.example.desafioQuality.dtos.responses.PropertyValueResponse;
import com.example.desafioQuality.dtos.responses.PropertyTotalSquareMetersResponse;

public interface PropertyService {

    PropertyTotalSquareMetersResponse getTotalSquareMeters(PropertyDTO propertyDTO);

    PropertyValueResponse getPropertyValue(PropertyDTO propertyDTO);
}
