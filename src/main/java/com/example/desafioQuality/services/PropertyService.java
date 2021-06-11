package com.example.desafioQuality.services;

import com.example.desafioQuality.dtos.PropertyDTO;
import com.example.desafioQuality.dtos.responses.PropertyValueResponse;
import com.example.desafioQuality.dtos.responses.PropertyTotalSquareMetersResponse;
import com.example.desafioQuality.models.Room;

public interface PropertyService {

    PropertyTotalSquareMetersResponse getTotalSquareMeters(PropertyDTO propertyDTO);

    PropertyValueResponse getPropertyValue(PropertyDTO propertyDTO);

    Room getBiggestRoom(PropertyDTO propertyDTO);
}
