package com.example.desafioQuality.services;

import com.example.desafioQuality.dtos.PropertyRequest;
import com.example.desafioQuality.dtos.responses.PropertyTotalSquareMetersResponse;
import com.example.desafioQuality.dtos.responses.PropertyValueResponse;
import com.example.desafioQuality.dtos.responses.SizesPerRoomResponse;
import com.example.desafioQuality.models.District;
import com.example.desafioQuality.models.Property;
import com.example.desafioQuality.models.Room;
import com.example.desafioQuality.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class PropertyServiceImpl implements PropertyService{

    private final PropertyRepository propertyRepository;

    @Override
    public PropertyTotalSquareMetersResponse getTotalSquareMeters(PropertyRequest propertyRequest) {
        Property property = getPropertyByPropertyRequest(propertyRequest);

        double propertyTotalSquareMeters = property.calculateTotalSquareMeters();

        return new PropertyTotalSquareMetersResponse(property.getName(), propertyTotalSquareMeters);
    }

    @Override
    public PropertyValueResponse getPropertyValue(PropertyRequest propertyRequest) {

        Property property = getPropertyByPropertyRequest(propertyRequest);
        double propertyValue = property.calculateValue();

        return new PropertyValueResponse(property.getName(), propertyValue);
    }

    @Override
    public Room getBiggestRoom(PropertyRequest propertyRequest) {
        Property property = getPropertyByPropertyRequest(propertyRequest);

        return property.getBiggestRoom();
    }

    @Override
    public List<SizesPerRoomResponse> getSizesPerRoom(PropertyRequest propertyRequest) {
        Property property = getPropertyByPropertyRequest(propertyRequest);

        List<SizesPerRoomResponse> roomResponsesList = new ArrayList<>();
        property.getRoomsList().forEach(
                room -> roomResponsesList.add(new SizesPerRoomResponse(room))
        );

        return  roomResponsesList;
    }

    public Property getPropertyByPropertyRequest(PropertyRequest propertyRequest){
        District district = propertyRepository.findDistrictByName(propertyRequest.getProp_district());
        return new Property(propertyRequest,district);
    }


}
