package com.example.desafioQuality.services;

import com.example.desafioQuality.dtos.PropertyRequest;
import com.example.desafioQuality.dtos.RoomDTO;
import com.example.desafioQuality.dtos.responses.PropertyTotalSquareMetersResponse;
import com.example.desafioQuality.dtos.responses.PropertyValueResponse;
import com.example.desafioQuality.dtos.responses.SizesPerRoomResponse;
import com.example.desafioQuality.models.District;
import com.example.desafioQuality.models.Property;
import com.example.desafioQuality.models.Room;
import com.example.desafioQuality.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


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
    public SizesPerRoomResponse getSizesPerRoom(PropertyRequest propertyRequest) {
        Property property = getPropertyByPropertyRequest(propertyRequest);

        SizesPerRoomResponse sizesPerRoomResponse = new SizesPerRoomResponse();
        property.getRoomsList().forEach(
                room -> sizesPerRoomResponse.getRoomsList().add(new RoomDTO(room))
        );

        return  sizesPerRoomResponse;
    }

    public Property getPropertyByPropertyRequest(PropertyRequest propertyRequest){
        try{
            District district = propertyRepository.findDistrictByName(propertyRequest.getProp_district());
            return new Property(propertyRequest,district);
        }catch (NoSuchElementException ex){
            throw new NoSuchElementException("Bairro não encontrado");
        }

    }


}
