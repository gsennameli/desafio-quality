package com.example.desafioQuality.services;

import com.example.desafioQuality.dtos.PropertyDTO;
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
    public double getTotalSquareMeters(PropertyDTO propertyDTO) {
        District district = propertyRepository.findDistrictByName(propertyDTO.getProp_district());
        Property property = new Property(propertyDTO,district);

        return property.totalSquareMeters();
    }
}
