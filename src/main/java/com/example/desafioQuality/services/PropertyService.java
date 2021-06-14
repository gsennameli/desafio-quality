package com.example.desafioQuality.services;

import com.example.desafioQuality.dtos.PropertyRequest;
import com.example.desafioQuality.dtos.responses.PropertyValueResponse;
import com.example.desafioQuality.dtos.responses.PropertyTotalSquareMetersResponse;
import com.example.desafioQuality.dtos.responses.SizesPerRoomResponse;
import com.example.desafioQuality.models.Property;
import com.example.desafioQuality.models.Room;

import java.util.List;

public interface PropertyService {

    PropertyTotalSquareMetersResponse getTotalSquareMeters(PropertyRequest propertyRequest);

    PropertyValueResponse getPropertyValue(PropertyRequest propertyRequest);

    Room getBiggestRoom(PropertyRequest propertyRequest);

    SizesPerRoomResponse getSizesPerRoom(PropertyRequest propertyRequest);

    Property getPropertyByPropertyRequest(PropertyRequest propertyRequest);
}
