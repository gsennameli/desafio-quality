package com.example.desafioQuality.services;

import com.example.desafioQuality.dtos.PropertyDTO;
import com.example.desafioQuality.dtos.responses.PropertyTotalSquareMetersResponse;
import com.example.desafioQuality.dtos.responses.PropertyValueResponse;
import com.example.desafioQuality.models.District;
import com.example.desafioQuality.models.Property;
import com.example.desafioQuality.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PropertyServiceImpl implements PropertyService{

    private final PropertyRepository propertyRepository;

    @Override
    public PropertyTotalSquareMetersResponse getTotalSquareMeters(PropertyDTO propertyDTO) {
        District district = propertyRepository.findDistrictByName(propertyDTO.getProp_district());
        Property property = new Property(propertyDTO,district);

        double propertyTotalSquareMeters = property.calculateTotalSquareMeters();

        return new PropertyTotalSquareMetersResponse(property.getName(), propertyTotalSquareMeters);
    }

    @Override
    public PropertyValueResponse getPropertyValue(PropertyDTO propertyDTO) {
        District district = propertyRepository.findDistrictByName(propertyDTO.getProp_district());
        Property property = new Property(propertyDTO,district);

        double propertyValue = property.calculateValue();

        return new PropertyValueResponse(property.getName(), propertyValue);
    }


}
